package com.example.timetable.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.adapters.ScheduleAdapter
import com.example.timetable.viewmodel.ScheludeViewModel

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
        var bundle = arguments
        var typeTransport = bundle?.getString("typeTransport")?:""
        var idBusStop = bundle?.getString("idBusStop")?:""
        var numberTransport = bundle?.getString("numberTransport")?:""
        var timeTableRecyclerView = view.findViewById<RecyclerView>(R.id.timeTableRecyclerView)
        var direction = bundle?.getString("d")?:"0"
        var recyclerViewManager = LinearLayoutManager(view.context)
        var dividerItemDecoration = DividerItemDecoration(timeTableRecyclerView.context, DividerItemDecoration.VERTICAL)
        timeTableRecyclerView.addItemDecoration(dividerItemDecoration)





        viewModel.timeTableMLD.observe(viewLifecycleOwner, Observer{
            it.Schedule?.HourLines?.let {
                var timeTableAdapter = ScheduleAdapter(it, view.context)
                timeTableRecyclerView.layoutManager = recyclerViewManager
                timeTableRecyclerView.adapter = timeTableAdapter
            }
        })

        viewModel.fetchSchelude((activity?.application as? TimeTableApp)?.timeTableApi,typeTransport,numberTransport,idBusStop,direction )



    }

}