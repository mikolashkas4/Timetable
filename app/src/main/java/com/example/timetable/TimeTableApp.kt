package com.example.timetable

import android.app.Application
import com.example.timetable.data.GetListBus
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

public class TimeTableApp: Application() {
    lateinit var getListBus: GetListBus;

    override fun onCreate() {
        super.onCreate()
        configurateRetrofit()
    }


    private fun configurateRetrofit() {

        var httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoginInterceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://minsktrans.by")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}