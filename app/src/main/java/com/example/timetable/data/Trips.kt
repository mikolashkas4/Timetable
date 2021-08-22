package com.example.timetable.data

import com.google.gson.annotations.SerializedName

data class Trips (
    @SerializedName("NameA")
    val nameRouteToTheFirstSide:String,
    @SerializedName("EndStopA")
    val endStopToTheFirstSide:String,
    @SerializedName("StopsA")
    val busStopToTheFirstSide:List<CoordinatesBusStop>,
    @SerializedName("StopNamesA")
    val nameBusStopToTheFirstSide:List<String>,
    @SerializedName("NameB")
    val nameRouteToTheSecondSide:String,
    @SerializedName("EndStopB")
    val endStopToTheSecondSide:String,
    @SerializedName("StopsB")
    val busStopToTheSecondSide:List<CoordinatesBusStop>,
    @SerializedName("StopNamesB")
    val nameBusStopToTheSecondSide:List<String>,
    @SerializedName("Info")
    val information:String,
    @SerializedName("OtherDirections")
    val otherDirections:List<OtherDirection>
    ){
}