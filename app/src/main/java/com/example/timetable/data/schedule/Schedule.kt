package com.example.timetable.data.schedule

data class Schedule (
    var DaysOfWeek:Int,
    var StopType:Int,
    var HourLines:ArrayList<HourLines>
        ){
}