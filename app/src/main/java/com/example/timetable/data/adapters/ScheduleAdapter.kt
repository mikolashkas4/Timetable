package com.example.timetable.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timetable.R
import com.example.timetable.data.schedule.HourLines

class ScheduleAdapter:RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    var layoutInflater:LayoutInflater
    var timesList:ArrayList<HourLines>

    constructor(timesList: ArrayList<HourLines>, context:Context) : super() {
        this.layoutInflater = LayoutInflater.from(context);
        this.timesList = timesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
        var view = layoutInflater.inflate(R.layout.times_list_item, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return timesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if (timesList!= null) {
                var hour = timesList.get(position).Hour
                var minutes = timesList.get(position).Minutes
                var minutesArray = minutes.split(" ").toTypedArray()
                var timeString: String = ""
                minutesArray.forEach {
                    timeString += hour + ":" + it + " "

                }

                holder.timeTextView.text = timeString
            }
    }


    public class ViewHolder:RecyclerView.ViewHolder{
        var timeTextView:TextView;
        constructor(itemView: View) : super(itemView){
            timeTextView = itemView.findViewById(R.id.timeTextView)
        }
    }
}