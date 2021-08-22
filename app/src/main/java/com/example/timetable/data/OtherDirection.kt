package com.example.timetable.data

import com.google.gson.annotations.SerializedName

data class OtherDirection (
    @SerializedName("Name")
    val nameRoute:String,
    @SerializedName("EndStop")
    val endStop:String,
    @SerializedName("Stops")
    val busStopCoordinates:List<CoordinatesBusStop>,
    @SerializedName("StopNames")
    val nameBusStop:List<String>,
    @SerializedName("direction")
    val direction: Int,
    @SerializedName("directionStr")
    val directionStr:String
){}