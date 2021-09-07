package com.example.timetable.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnChildClickListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.trips.CoordinatesBusStop
import com.example.timetable.data.trips.Trips
import com.example.timetable.data.adapters.TripsExpandableListAdapter
import com.example.timetable.viewmodel.TripsViewModel


class TripsFragment : Fragment() {
    private var tripsNameList: ArrayList<String> = ArrayList()
    private var tripsMap = HashMap<String, ArrayList<String>>()
    private var tripsViewModel = TripsViewModel()
    private lateinit var trips: Trips
    var coordinateMap = HashMap<String, ArrayList<CoordinatesBusStop>>()


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
        var tripsExpandableListAdapter: TripsExpandableListAdapter


        tripsViewModel.tripsMLD.observe(viewLifecycleOwner, Observer {
            tripsExpandableListAdapter = createDataFromAdapter(it, view);
            routesList.setAdapter(tripsExpandableListAdapter)
        })

        tripsViewModel.fetchBusRouteList(
            (activity?.application as? TimeTableApp)?.timeTableApi,
            numberBus.toString(),
            typeTransport.toString()
        )


        routesList.setOnChildClickListener(OnChildClickListener { parent, v, groupPosition, childPosition, id ->
            var busStopName =  parent.expandableListAdapter.getChild(groupPosition,childPosition)
            var idBusStop:String = coordinateMap.get(parent.expandableListAdapter.getGroup(groupPosition))?.get(childPosition)?.Id.toString()
            var bundle:Bundle = Bundle()
            if (trips.otherDirections.isNotEmpty())
            {
                for (name in tripsNameList) {
                    trips.otherDirections.forEach {
                        if (it.nameRoute ==name)
                        {
                            bundle?.putString("d",it.direction.toString()+it.directionStr)
                        }
                        else
                        {
                            bundle?.putString("d", null)
                        }
                    }
                }
            }


            bundle.putString("numberTransport",numberBus)
            bundle.putString("typeTransport", typeTransport)
            bundle.putString("busStopName", busStopName.toString())
            bundle.putString("idBusStop", idBusStop)
            view.findNavController().navigate(R.id.timeTableFragment, bundle)
            false
        })
    }





    private fun createDataFromAdapter(trips: Trips?, view:View) : TripsExpandableListAdapter {
        trips?.let {
        coordinateMap.put(it.nameRouteToTheFirstSide, it.busStopCoordinateToTheFirstSide)
        coordinateMap.put(it.nameRouteToTheSecondSide, it.busStopCoordinateToTheSecondSide)
        tripsMap.put(it.nameRouteToTheFirstSide, it.nameBusStopToTheFirstSide)
        tripsMap.put(it.nameRouteToTheSecondSide, it.nameBusStopToTheSecondSide)
        tripsNameList.add(it.nameRouteToTheFirstSide)
        tripsNameList.add(it.nameRouteToTheSecondSide)
        it.otherDirections.forEach {
            coordinateMap.put(it.nameRoute, it.busStopCoordinates)
            tripsMap.put(it.nameRoute, it.nameBusStop)
            tripsNameList.add(it.nameRoute)
        }

        }
        var tripsExpandableListAdapter = TripsExpandableListAdapter(tripsNameList, tripsMap, view.context)
        return tripsExpandableListAdapter
    }
}