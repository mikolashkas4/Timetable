package com.example.timetable.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.adapters.ScheduleAdapter
import com.example.timetable.data.schedule.HourLines
import com.example.timetable.viewmodel.ScheludeViewModel
import java.util.*
import kotlin.collections.ArrayList

class ScheduleFragment : Fragment() {

    companion object {
        fun newInstance() = ScheduleFragment()
    }

    private var viewModel = ScheludeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.schedule_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var emptyList = ArrayList<HourLines>()


        var weekdaysAdapter:ScheduleAdapter = ScheduleAdapter(emptyList,view.context)
        var weekendsAdapter:ScheduleAdapter = ScheduleAdapter(emptyList,view.context)


        var bundle = arguments
        var typeTransport = bundle?.getString("typeTransport")?:""
        var idBusStop = bundle?.getString("idBusStop")?:""
        var numberTransport = bundle?.getString("numberTransport")?:""
        var timeTableRecyclerView = view.findViewById<RecyclerView>(R.id.timeTableRecyclerView)
        var direction = bundle?.getString("d")?:"0"
        var recyclerViewManager = LinearLayoutManager(view.context)
        var daysSwitcher = view.findViewById<RadioGroup>(R.id.daysSwitcher)
        var dividerItemDecoration = DividerItemDecoration(timeTableRecyclerView.context, DividerItemDecoration.VERTICAL)
        timeTableRecyclerView.addItemDecoration(dividerItemDecoration)


        daysSwitcher.setOnCheckedChangeListener { group, checkedId ->

            daysSwitcherCheckedChange(group,checkedId, timeTableRecyclerView, recyclerViewManager, weekdaysAdapter, weekendsAdapter)


        }

        viewModel.timeTableMLD.observe(viewLifecycleOwner, Observer{
            it.DaysOfWeek?.let {
                it.forEach {
                    if(it.DaysOfWeek == 31)
                    {
                        weekdaysAdapter = ScheduleAdapter(it.HourLines, view.context)
                    }
                    else if(it.DaysOfWeek == 96)
                    {
                        weekendsAdapter = ScheduleAdapter(it.HourLines, view.context)
                    }
                }
            }
            setDayRadioButton(daysSwitcher)
        })

        viewModel.fetchSchelude((activity?.application as? TimeTableApp)?.timeTableApi,typeTransport,numberTransport,idBusStop,direction )

    }

    private fun daysSwitcherCheckedChange(group: RadioGroup?, checkedId: Int, timeTableRecyclerView: RecyclerView?, recyclerViewManager: LinearLayoutManager, weekdaysAdapter: ScheduleAdapter, weekendsAdapter: ScheduleAdapter) {
        when(checkedId)
        {

            R.id.mondayRadiobutton -> {
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekdaysAdapter
            }
            R.id.tuesdayRadiobutton->{
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekdaysAdapter
            }
            R.id.wendesdayRadiobutton->{
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekdaysAdapter
            }
            R.id.thursdayRadiobutton->
            {
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekdaysAdapter
            }
            R.id.fridayRadiobutton->{
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekdaysAdapter
            }
            R.id.saturdayRadiobutton->
            {
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekendsAdapter
            }
            R.id.sundayRadiobutton->{
                timeTableRecyclerView?.layoutManager = recyclerViewManager
                timeTableRecyclerView?.adapter = weekendsAdapter
            }

        }
    }



    private fun setDayRadioButton(daysSwitcher: RadioGroup) {
        val d = Date()
        when(d.day)
        {

            1->{daysSwitcher.check(R.id.mondayRadiobutton)}
            2->{daysSwitcher.check(R.id.tuesdayRadiobutton)}
            3->{daysSwitcher.check(R.id.wendesdayRadiobutton)}
            4->{daysSwitcher.check(R.id.thursdayRadiobutton)}
            5->{daysSwitcher.check(R.id.fridayRadiobutton)}
            6->{daysSwitcher.check(R.id.sundayRadiobutton)}
            7->{daysSwitcher.check(R.id.saturdayRadiobutton)}
        }


    }

}