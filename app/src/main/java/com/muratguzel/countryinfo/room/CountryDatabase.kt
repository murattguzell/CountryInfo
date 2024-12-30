package com.muratguzel.countryinfo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.muratguzel.countryinfo.data.entity.Country

@Database(entities = arrayOf(Country::class), version = 1)
@TypeConverters(TypeConverter::class)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    companion object {

        @Volatile
        private var instance: CountryDatabase? = null
        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CountryDatabase::class.java,
            "CountryDatabase"
        ).build()
    }
}