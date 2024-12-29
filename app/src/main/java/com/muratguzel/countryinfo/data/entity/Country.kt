package com.muratguzel.countryinfo.data.entity


data class CountryItem(
    val Country1: Country,
    val Country2: Country,
)

data class Country(
    val name: String?,
    val capital: String?,
    val region: String?,
    val currency: String?,
    val flag: String?,
    val language: String?,
    var childItemList: List<ChildItem> = listOf(),
    var isOpen:Boolean = false
)

data class ChildItem(
    val name: String?,
    val flag: Int?,

)