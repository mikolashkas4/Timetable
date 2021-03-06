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
import com.example.timetable.data.transport.Route
import com.example.timetable.data.adapters.TransportListAdapter
import com.example.timetable.viewmodel.TramViewModel

class TramFragment : Fragment(R.layout.tram_fragment) {


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val tramViewModel = ViewModelProvider(this).get(TramViewModel::class.java)
            val tramListListView: ListView = view.findViewById(R.id.tramList)
            var tramList:ArrayList<Route> = ArrayList<Route>()

            tramViewModel.tramData.observe(viewLifecycleOwner, Observer {
                tramList = it
                tramListListView.adapter = TransportListAdapter(view.context, R.layout.transport_list_item, it)
            })

            tramViewModel.fetchTramList((activity?.application as? TimeTableApp)?.timeTableApi)

            tramListListView.setOnItemClickListener(){ parent, view, position, id ->
                busListItemClick(tramList,position,view)
            }
        }

    private fun busListItemClick(tramList: ArrayList<Route>, position: Int, view: View?) {
        var numberTram = tramList.get(position).number
        var bundle:Bundle = Bundle()
        bundle.putString("numberBus",numberTram )
        bundle.putString("typeTransport", RequestsInfo.TRAM)

        view?.findNavController()?.navigate(R.id.tripsFragment, bundle)
        Log.e("Click", numberTram)
    }
}