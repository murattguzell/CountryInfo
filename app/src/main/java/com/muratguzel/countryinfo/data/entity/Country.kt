package com.muratguzel.countryinfo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class CountryItem(
    val Country1: Country,
    val Country2: Country,
)

@Entity
data class Country(
    @ColumnInfo("name")
    val name: String?,
    @ColumnInfo("capital")
    val capital: String?,
    @ColumnInfo("region")
    val region: String?,
    @ColumnInfo("currency")
    val currency: String?,
    @ColumnInfo("flag")
    val flag: String?,
    @ColumnInfo("language")
    val language: String?,
    @ColumnInfo("childItemList")
    var childItemList: List<ChildItem> = listOf(),
    @ColumnInfo("isOpen")
    var isOpen: Boolean = false,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid = 0
}

data class ChildItem(
    val name: String?,
    val logo: Int?,
)