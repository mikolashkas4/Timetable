package com.example.timetable.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.Observer
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.Route
import com.example.timetable.viewmodel.TramViewModel
import com.example.timetable.viewmodel.TrolleybusViewModel

class TrolleybusFragment : Fragment(R.layout.trolleybus_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val trolleybusViewModel = ViewModelProvider(this).get(TrolleybusViewModel::class.java)
        val trolleybusListListView: ListView = view.findViewById(R.id.trolleybusList)
        var TransportListAdapter:TransportListAdapter;
        var trolleybusList:ArrayList<Route> = ArrayList<Route>()



        trolleybusViewModel.trolleybusData.observe(viewLifecycleOwner, Observer {
            trolleybusList = it
            trolleybusListListView.adapter = TransportListAdapter(view.context, R.layout.transport_list_item, it)

        })

        trolleybusViewModel.fetchTrolleybusList((activity?.application as? TimeTableApp)?.timeTableApi)


         trolleybusListListView.setOnItemClickListener(){ parent, view, position, id ->
            Log.e("TAG",trolleybusList.get(position).number)
        }
    }

}