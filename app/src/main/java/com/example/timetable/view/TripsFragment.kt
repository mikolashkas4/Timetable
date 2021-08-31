package com.example.timetable.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.timetable.viewmodel.TripsViewModel
import com.example.timetable.R
import com.example.timetable.TimeTableApp

import com.example.timetable.data.Trips
import com.example.timetable.data.TripsExpandableListAdapter

class TripsFragment : Fragment() {
    private var tripsNameList:ArrayList<String> = ArrayList()
    private var tripsMap = HashMap<String,ArrayList<String>>()




    private var tripsViewModel = TripsViewModel()
    private lateinit var trips:Trips


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trips_fragment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tripsViewModel = ViewModelProvider(this).get(TripsViewModel::class.java)
        // TODO: Use the ViewModel
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = arguments
        var numberBus = bundle?.getString("numberBus")
        var typeTransport = bundle?.getString("typeTransport")

        var routesList = view.findViewById<ExpandableListView>(R.id.routesList)
        var tripsExpandableListAdapter:TripsExpandableListAdapter


        tripsViewModel.tripsMLD.observe(viewLifecycleOwner, Observer {


                tripsMap.put(it.nameRouteToTheFirstSide, it.nameBusStopToTheFirstSide)
                tripsMap.put(it.nameRouteToTheSecondSide, it.nameBusStopToTheSecondSide)
                tripsNameList.add(it.nameRouteToTheSecondSide)
                tripsNameList.add(it.nameRouteToTheSecondSide)
                it.otherDirections.forEach {
                    tripsMap.put(it.nameRoute, it.nameBusStop)
                    tripsNameList.add(it.nameRoute)
                }
                tripsExpandableListAdapter = TripsExpandableListAdapter(tripsNameList,tripsMap, view.context)
                routesList.setAdapter(tripsExpandableListAdapter)



        })

        tripsViewModel.fetchBusRouteList((activity?.application as? TimeTableApp)?.timeTableApi, numberBus.toString(), typeTransport.toString() )



    }


}