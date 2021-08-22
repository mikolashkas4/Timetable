package com.example.timetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.timetable.data.TimeTableApi
import com.example.timetable.view.busList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, busList())
            .commit()


    }
}