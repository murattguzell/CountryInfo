package com.muratguzel.countryinfo.retrofit

import com.muratguzel.countryinfo.data.entity.Country
import retrofit2.http.GET

interface CountryApi {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getData() : List<Country>
}