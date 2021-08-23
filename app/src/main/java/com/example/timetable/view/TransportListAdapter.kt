package com.example.timetable.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.timetable.R
import com.example.timetable.data.BusListResponse
import com.example.timetable.data.Route
import java.security.AccessControlContext

class TransportListAdapter:ArrayAdapter<Route> {
    private var inflater:LayoutInflater
    private var layout:Int
    private var busList:ArrayList<Route>
constructor(context: Context,resource:Int, busList:ArrayList<Route>):super(
    context,
    resource,
    busList
    )
{
    this.busList = busList;
    this.layout = resource;
    this.inflater = LayoutInflater.from(context);
}


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view =inflater.inflate(this.layout, parent, false)
        var busNumber = view.findViewById<TextView>(R.id.busNumberTextView)
        var routeName = view.findViewById<TextView>(R.id.busRoutNameTextView)


        var busItem = busList.get(position)

        busNumber.setText(busItem.number)
        routeName.setText(busItem.name)
        return view
    }
}