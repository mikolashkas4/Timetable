package com.example.timetable.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.timetable.TimeTableApp
import com.example.timetable.data.BusListResponse
import com.example.timetable.data.GetListBus
import com.example.timetable.viewmodel.busListViewModel


class busList : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val busListViewModel = ViewModelProvider(this).get(busListViewModel::class.java)
        busListViewModel.fetchBusList((activity?.application as? TimeTableApp)?.getListBus)
    }

}