package com.example.timetable.data

import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("SortPrefix")
    val sortPrefix:Int,

    @SerializedName("Number")
    val number:String,

    @SerializedName("Name")
    val name:String,

    @SerializedName("IsWorkToday")
    val isWorkToday:Boolean,

    @SerializedName("ShtNameA")
    val shortName:String
) {

}