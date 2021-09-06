package com.example.timetable.data.adapters


import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.timetable.R


class TripsExpandableListAdapter : BaseExpandableListAdapter{
    private var groupList:ArrayList<String>
    private var tripsCollection:HashMap<String, ArrayList<String>>
    private var context:Context

    constructor(groupList:ArrayList<String>, tripsCollection:HashMap<String, ArrayList<String>>, context: Context)
    {
        this.groupList = groupList
        this.tripsCollection = tripsCollection
        this.context = context
    }

    override fun getGroupCount(): Int {
        return tripsCollection.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
      return tripsCollection.get( groupList.get(groupPosition))?.size?:0
    }

    override fun getGroup(groupPosition: Int): String {
        return groupList.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return tripsCollection.get(groupList.get(groupPosition))?.get(childPosition)?:""
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
       return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
       return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {


        if (convertView == null)
        {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            var view = layoutInflater.inflate(R.layout.trips_name_expandable_item, null)

            var tripName = getGroup(groupPosition).toString()
            val groupTextView:TextView = view.findViewById(R.id.tripsNameItem)
            groupTextView.setTypeface(null, Typeface.BOLD)
            groupTextView.text = tripName
            return view
        }
        else
        {
            var tripName = getGroup(groupPosition).toString()
            val groupTextView:TextView = convertView.findViewById(R.id.tripsNameItem)
            groupTextView.setTypeface(null, Typeface.BOLD)
            groupTextView.text = tripName
            return convertView
        }


    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var layoutInflater: LayoutInflater = LayoutInflater.from(context)
        var view:View = convertView?:layoutInflater.inflate(R.layout.bus_stops_expandable_item, null)
        var busStopNames = getChild(groupPosition,childPosition)
        var childTextView:TextView = view.findViewById(R.id.busStopsItem)
        childTextView.text  = busStopNames.toString()

        return view







    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
       return true
    }


}
