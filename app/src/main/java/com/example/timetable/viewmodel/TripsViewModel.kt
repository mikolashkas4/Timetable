package com.example.timetable.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.TimeTableApi
import com.example.timetable.data.Trips
import com.example.timetable.data.TripsExpandableListAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.reflect.Type

class TripsViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private var tripsMap = HashMap<String,List<String>>()
    var tripsMLD = MutableLiveData<Trips>()
    private lateinit var tripsNameList:List<String>


    override fun onCleared() {

        super.onCleared()
    }

    fun fetchBusRouteList(timeTableApi: TimeTableApi?, numberBus:String, typeTransport:String){
        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getListBusStop(
                RequestsInfo.MINSK, typeTransport,numberBus,
                RequestsInfo.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.e("TRIPS", it.Trips.toString())
                        tripsMLD.value = it.Trips
                    },
                    {
                        Log.e("Error bus route",it.message.toString())
                    }
                )
            )
        }
    }




}