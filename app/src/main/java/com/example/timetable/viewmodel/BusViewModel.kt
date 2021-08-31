package com.example.timetable.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.Route
import com.example.timetable.data.TimeTableApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class BusViewModel(application: Application):AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    var busData = MutableLiveData<ArrayList<Route>>()
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchBusList(timeTableApi: TimeTableApi?) {
        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getTransportList(RequestsInfo.MINSK, RequestsInfo.BUS, RequestsInfo.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                        busData.value = it.Routes

                        Log.e("BUS", it.Routes.toString())

                    },
                    {

                    }
                )
            )
        }
    }




}