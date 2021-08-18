package com.example.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.timetable.data.GetListBus
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class busListViewModel(application: Application):AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
    fun fetchBusList(getListBus: GetListBus?) {
        val body = HashMap<String?, String?>()
        body["p"] = "minsk"
        body["tt"] = "bus"
        body["__RequestVerificationToken"] =
            "yW-O145tzkmaziDObHzx444HMadVXJLc-hZ_ktO4qyrRhgRyBqc4YPXjChWWPilWHAyLdtHhSVLdOeAsX-8fbf1XB7OjDuFJYvvlE7eCT2g1"

        getListBus?.let {
            compositeDisposable.add(getListBus.getList(body)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                    },
                    {

                    }
                ))
        }
    }

}