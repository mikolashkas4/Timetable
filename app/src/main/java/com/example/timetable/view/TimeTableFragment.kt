package com.example.timetable.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetable.R
import com.example.timetable.TimeTableApp
import com.example.timetable.data.adapters.TimeTableAdapter
import com.example.timetable.viewmodel.TimeTableViewModel

class TimeTableFragment : Fragment() {

    companion object {
        fun newInstance() = TimeTableFragment()
    }

    private var viewModel = TimeTableViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.time_table_fragment, container, false)
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

        var recyclerViewManager = LinearLayoutManager(view.context)






        viewModel.timeTableMLD.observe(viewLifecycleOwner, Observer{
            var timeTableAdapter = TimeTableAdapter(it.Schedule.HourLines, view.context)
            timeTableRecyclerView.layoutManager= recyclerViewManager
            timeTableRecyclerView.adapter = timeTableAdapter
        })

        viewModel.fetchTimeTable((activity?.application as? TimeTableApp)?.timeTableApi,typeTransport,numberTransport,idBusStop )



    }

}