package com.muratguzel.countryinfo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.muratguzel.countryinfo.data.entity.Country

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>

    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()
}