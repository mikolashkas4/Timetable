package com.example.timetable.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timetable.R
import com.example.timetable.viewmodel.BottomMenuViewModel

class BottomMenuFragment : Fragment() {

    companion object {
        fun newInstance() = BottomMenuFragment()
    }

    private lateinit var viewModel: BottomMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}