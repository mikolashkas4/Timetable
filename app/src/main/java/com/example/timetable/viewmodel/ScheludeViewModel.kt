package com.example.timetable.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable.data.RequestsInfo
import com.example.timetable.data.TimeTableApi
import com.example.timetable.data.schedule.ScheduleResponce
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ScheludeViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var timeTableMLD = MutableLiveData<ScheduleResponce>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun fetchSchelude(timeTableApi: TimeTableApi?, typeTransport:String, nubmerTransport:String, idBusStop:String, direction:String) {
        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getTimeTable(RequestsInfo.MINSK, typeTransport, nubmerTransport, idBusStop, direction, RequestsInfo.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        timeTableMLD.value = it
                        Log.e("TimeTable", it.toString())
                    },
                    {
                        Log.e("ERRORTIMETABLE", it.message.toString())
                    }
                )
            )
        }
    }
}