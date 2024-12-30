package com.muratguzel.countryinfo.retrofit

class ApiUtils {
    companion object{
        val BASE_URL ="https://raw.githubusercontent.com/"
        fun getCountryApi() : CountryApi{
            return RetrofitClient.getClient(BASE_URL).create(CountryApi::class.java)
        }
    }
}