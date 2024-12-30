package com.muratguzel.countryinfo.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.muratguzel.countryinfo.data.entity.ChildItem

class TypeConverter {
    // List<ChildItem> -> String (JSON)
    @TypeConverter
    fun fromChildItemList(list: List<ChildItem>): String {
        return Gson().toJson(list)
    }

    // String (JSON) -> List<ChildItem>
    @TypeConverter
    fun toChildItemList(value: String): List<ChildItem> {
        val listType = object : TypeToken<List<ChildItem>>() {}.type
        return Gson().fromJson(value, listType)
    }
}