package com.example.reskilling.model.local

import androidx.room.TypeConverter
import com.example.reskilling.model.pojos.Work
import com.google.gson.Gson

class HeightTypeConverter {
    @TypeConverter
    fun fromListToString(list: List<String>) = Gson().toJson(list)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

}