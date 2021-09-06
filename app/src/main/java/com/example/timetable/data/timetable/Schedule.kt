package com.example.timetable.data.timetable

import com.example.timetable.data.timetable.HourLines

data class Schedule (
    var DaysOfWeek:Int,
    var StopType:Int,
    var HourLines:ArrayList<HourLines>
        ){
}