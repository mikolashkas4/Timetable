package com.example.timetable.data.trips

import com.google.gson.annotations.SerializedName

data class CoordinatesBusStop (
    val Id:Int,
    val Latitude:Double,
    val Longitude:Double,
    val Bearing:Int
        ) {
}