package com.example.timetable.data.schedule

import com.example.timetable.data.commons.OperInfo

data class ScheduleResponce(
    var Schedule: Schedule,
    var DaysOfWeek:ArrayList<Schedule>,
    var InfoExclusion:String,
    var WorkingDay:Int,
    var OperInfo: OperInfo,
    var IsLastStop:Boolean) {
}