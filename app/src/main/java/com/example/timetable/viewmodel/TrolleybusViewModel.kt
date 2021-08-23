package com.example.timetable.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.Route
import com.example.timetable.data.TimeTableApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TrolleybusViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var trolleybusData = MutableLiveData<ArrayList<Route>>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun fetchTrolleybusList(timeTableApi: TimeTableApi?) {
        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getTransportList(RequestsInfo.MINSK, RequestsInfo.TROLLEYBUS, RequestsInfo.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                        trolleybusData.value = it.Routes

                        Log.e("TAG", it.Routes.toString())

                    },
                    {

                    }
                )
            )
        }
    }
}