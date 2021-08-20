package com.example.timetable.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.timetable.data.BusListResponse
import com.example.timetable.data.Route
import com.example.timetable.data.TimeTableApi
import com.example.timetable.view.busList
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.math.log

class busListViewModel(application: Application):AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()


    val data = MutableLiveData<BusListResponse>()
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchBusList(timeTableApi: TimeTableApi?) {
        val county = "minsk"
        val transport = "bus"
        val token = "yW-O145tzkmaziDObHzx444HMadVXJLc-hZ_ktO4qyrRhgRyBqc4YPXjChWWPilWHAyLdtHhSVLdOeAsX-8fbf1XB7OjDuFJYvvlE7eCT2g1"

        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getList(county, transport, token)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                       // Toast.makeText(getApplication(), it.Routes.toString(), Toast.LENGTH_SHORT).show()
                        data.value = it
                    },
                    {

                    }
                ))
        }
    }

}