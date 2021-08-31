package com.example.timetable.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.Route
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
             var numberTrolletBus = trolleybusList.get(position).number
             var bundle:Bundle = Bundle()
             bundle.putString("numberBus",numberTrolletBus )
             bundle.putString("typeTransport", RequestsInfo.TROLLEYBUS)

             view.findNavController().navigate(R.id.tripsFragment, bundle)
             Log.e("Click", numberTrolletBus)
        }
    }

}