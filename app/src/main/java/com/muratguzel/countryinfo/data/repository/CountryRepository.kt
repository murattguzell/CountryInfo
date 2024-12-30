package com.muratguzel.countryinfo.data.repository

import android.content.Context
import com.muratguzel.countryinfo.data.datasource.CountryDataSource
import com.muratguzel.countryinfo.data.entity.CountryItem

class CountryRepository(context: Context) {
    var cds = CountryDataSource(context)

    suspend fun getDataFromInternet(context: Context): List<CountryItem> {
        return cds.getDataFromInternet(context)

    }

    suspend fun refreshData(context: Context): List<CountryItem> {
        return cds.refreshData(context)

    }
}