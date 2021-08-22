package com.example.timetable.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.lifecycle.*
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.viewmodel.busListViewModel



class busList : Fragment(R.layout.fragment_bus_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var outText:TextView = view.findViewById<TextView>(R.id.outText)
        val busListViewModel = ViewModelProvider(this).get(busListViewModel::class.java)
        busListViewModel.data.observe(viewLifecycleOwner, Observer {
            outText.text = it.Routes.toString()

            //outText.text = it.Routes.count().toString()
        })
        busListViewModel.fetchBusList((activity?.application as? TimeTableApp)?.timeTableApi)




    }




}