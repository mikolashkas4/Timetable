package com.example.timetable.data.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HourLines")
data class HourLines (
    @ColumnInfo(name="hour")
    var Hour:String,
    @ColumnInfo(name="minutes")
    var Minutes:String,

    var ApparelByMinutes:String){}


