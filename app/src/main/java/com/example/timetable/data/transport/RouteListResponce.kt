package com.example.timetable.data.transport

import com.example.timetable.data.commons.OperInfo
import com.example.timetable.data.trips.Trips

data class RouteListResponce (
    val OperInfo: OperInfo,
    val Trips: Trips
){
}