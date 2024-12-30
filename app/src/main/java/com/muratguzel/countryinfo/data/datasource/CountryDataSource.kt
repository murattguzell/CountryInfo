package com.muratguzel.countryinfo.data.datasource

import android.content.Context
import android.widget.Toast
import com.muratguzel.countryinfo.R
import com.muratguzel.countryinfo.data.entity.ChildItem
import com.muratguzel.countryinfo.data.entity.Country
import com.muratguzel.countryinfo.data.entity.CountryItem
import com.muratguzel.countryinfo.retrofit.ApiUtils
import com.muratguzel.countryinfo.room.CountryDatabase
import com.muratguzel.countryinfo.util.PrivateSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CountryDataSource(context: Context) {
    var countryApi = ApiUtils.getCountryApi()
    private val privatessharedpreferences = PrivateSharedPreferences(context.applicationContext)
    private val updateTime = 10 * 60 * 1000 * 1000 * 1000L
    lateinit var countryList: List<Country>


    suspend fun refreshData(context: Context): List<CountryItem> {
        val saveTime = privatessharedpreferences.getTime()
        val countryItemList: List<CountryItem>
        if (saveTime != null && saveTime != 0L && System.nanoTime() - saveTime < updateTime) {
            countryItemList = getDataFromRoom(context)

        } else {
            countryItemList = getDataFromInternet(context)
        }
        return countryItemList
    }

    suspend fun getDataFromInternet(context: Context): List<CountryItem> {
        return withContext(Dispatchers.IO) {
            countryList = countryApi.getData()
            val countryItemList = createCountryItem(countryList)
            saveToRoom(countryList, context)
            countryItemList
        }


    }


    suspend fun getDataFromRoom(context: Context): List<CountryItem> {
        return withContext(Dispatchers.IO) {
            val countryList =
                CountryDatabase(context.applicationContext).countryDao().getAllCountries()
            createCountryItem(countryList)
        }
    }

    private suspend fun saveToRoom(countryList: List<Country>, context: Context) {
        withContext(Dispatchers.IO) {

        }
        val dao = CountryDatabase(context.applicationContext).countryDao()
        dao.deleteAllCountries()
        val uuidList = dao.insertAll(*countryList.toTypedArray())
        var i = 0
        while (i < countryList.size) {
            countryList[i].uuid = uuidList[i].toInt()
            i++
        }
        privatessharedpreferences.saveTime(System.nanoTime())

    }

    fun createCountryItem(countryList: List<Country>): List<CountryItem> {

        for (country in countryList) {
            var childItemList = mutableListOf<ChildItem>()
            childItemList.add(ChildItem("Capital: ${country.capital}", R.drawable.capital_ic))
            childItemList.add(ChildItem("Region: ${country.region}", R.drawable.region))
            childItemList.add(ChildItem("Currency: ${country.currency}", R.drawable.money))
            childItemList.add(ChildItem("Languages: ${country.language}", R.drawable.languages))

            country.childItemList = childItemList

        }

        // CountryItem nesneleri için ikili gruplar oluşturuluyor
        val countryItemList = mutableListOf<CountryItem>()

        for (i in countryList.indices step 2) {
            val country1 = countryList[i]
            val country2 = if (i + 1 < countryList.size) countryList[i + 1] else null

            if (country2 != null) {
                countryItemList.add(CountryItem(country1, country2))
            } else {
                // Eğer tek bir ülke kaldıysa ve eşleştirilemiyorsa:
                countryItemList.add(CountryItem(country1, Country("", "", "", "", "", "")))
            }

        }

        return countryItemList

    }

}