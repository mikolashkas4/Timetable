package com.example.timetable.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import androidx.lifecycle.Observer
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.Route
import com.example.timetable.viewmodel.TramViewModel

class TramFragment : Fragment(R.layout.tram_fragment) {


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val tramViewModel = ViewModelProvider(this).get(TramViewModel::class.java)
            val tramListListView: ListView = view.findViewById(R.id.tramList)
            var TransportListAdapter:TransportListAdapter;
            var tramList:ArrayList<Route> = ArrayList<Route>()



            tramViewModel.tramData.observe(viewLifecycleOwner, Observer {
                tramList = it
                tramListListView.adapter = TransportListAdapter(view.context, R.layout.transport_list_item, it)

            })

            tramViewModel.fetchTramList((activity?.application as? TimeTableApp)?.timeTableApi)


            tramListListView.setOnItemClickListener(){ parent, view, position, id ->
                Log.e("TAG",tramList.get(position).number)
            }
        }
}