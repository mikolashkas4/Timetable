package com.example.timetable.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import androidx.lifecycle.*
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.Route
import com.example.timetable.viewmodel.BusViewModel



class BusFragment : Fragment(R.layout.bus_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val busListViewModel = ViewModelProvider(this).get(BusViewModel::class.java)
        val busListListView:ListView = view.findViewById(R.id.busFragment)
        var TransportListAdapter:TransportListAdapter;
        var busList:ArrayList<Route> = ArrayList<Route>()



        busListViewModel.busData.observe(viewLifecycleOwner, Observer {
            busList = it
            busListListView.adapter = TransportListAdapter(view.context, R.layout.transport_list_item, it)

        })

        busListViewModel.fetchBusList((activity?.application as? TimeTableApp)?.timeTableApi)
        busListListView.setOnItemClickListener(){ parent, view, position, id ->
            busList.get(position).number
        }
    }




}