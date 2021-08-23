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


class TramViewModel (application: Application):AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    var tramData = MutableLiveData<ArrayList<Route>>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun fetchTramList(timeTableApi: TimeTableApi?) {
        timeTableApi?.let {
            compositeDisposable.add(timeTableApi.getTransportList(RequestsInfo.MINSK, RequestsInfo.TRAM, RequestsInfo.TOKEN)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                        tramData.value = it.Routes

                        Log.e("TAG", it.Routes.toString())

                    },
                    {

                    }
                )
            )
        }
    }
}

