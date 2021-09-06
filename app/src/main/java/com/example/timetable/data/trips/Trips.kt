package com.example.timetable.data.trips

import com.google.gson.annotations.SerializedName

data class Trips (
    @SerializedName("NameA")
    val nameRouteToTheFirstSide:String,
    @SerializedName("EndStopA")
    val endStopToTheFirstSide:String,
    @SerializedName("StopsA")
    val busStopCoordinateToTheFirstSide:ArrayList<CoordinatesBusStop>,
    @SerializedName("StopNamesA")
    val nameBusStopToTheFirstSide:ArrayList<String>,
    @SerializedName("NameB")
    val nameRouteToTheSecondSide:String,
    @SerializedName("EndStopB")
    val endStopToTheSecondSide:String,
    @SerializedName("StopsB")
    val busStopCoordinateToTheSecondSide:ArrayList<CoordinatesBusStop>,
    @SerializedName("StopNamesB")
    val nameBusStopToTheSecondSide:ArrayList<String>,
    @SerializedName("Info")
    val information:String,
    @SerializedName("OtherDirections")
    val otherDirections:List<OtherDirection>
    ){
}