package com.example.timetable.view


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.transport.Route
import com.example.timetable.data.adapters.TransportListAdapter
import com.example.timetable.viewmodel.BusViewModel


class BusFragment : Fragment(R.layout.bus_fragment) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val busListViewModel = ViewModelProvider(this).get(BusViewModel::class.java)
        val busListListView:ListView = view.findViewById(R.id.busFragment)
        var busList = ArrayList<Route>()



        busListViewModel.busData.observe(viewLifecycleOwner, Observer {
            busList = it
            busListListView.adapter = TransportListAdapter(view.context, R.layout.transport_list_item, it)

        })

        busListViewModel.fetchBusList((activity?.application as? TimeTableApp)?.timeTableApi)

        busListListView.setOnItemClickListener(){ parent, view, position, id ->
            busListItemClick(busList,position,view)
        }
    }



    private fun busListItemClick(busList: ArrayList<Route>, position: Int, view: View?) {
        var numberBus = busList.get(position).number
        var bundle:Bundle = Bundle()
        bundle.putString("numberBus",numberBus )
        bundle.putString("typeTransport", RequestsInfo.BUS)

        view?.findNavController()?.navigate(R.id.tripsFragment, bundle)
        Log.e("Click", numberBus)
    }
}