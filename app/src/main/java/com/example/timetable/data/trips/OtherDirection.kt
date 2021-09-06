package com.example.timetable.data.trips

import com.example.timetable.data.trips.CoordinatesBusStop
import com.google.gson.annotations.SerializedName

data class OtherDirection (
    @SerializedName("Name")
    val nameRoute:String,
    @SerializedName("EndStop")
    val endStop:String,
    @SerializedName("Stops")
    val busStopCoordinates:ArrayList<CoordinatesBusStop>,
    @SerializedName("StopNames")
    val nameBusStop:ArrayList<String>,
    @SerializedName("direction")
    val direction: Int,
    @SerializedName("directionStr")
    val directionStr:String
){}