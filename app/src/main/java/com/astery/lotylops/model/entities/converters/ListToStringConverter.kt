package com.astery.lotylops.model.entities.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class ListToStringConverter {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        if (value == null) return null
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String>?): String? {
        if (list == null) return null
        val gson = Gson()
        return gson.toJson(list)
    }
}