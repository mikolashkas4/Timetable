package com.example.timetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timetable.data.GetListBus
import com.example.timetable.view.busList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var getListBus: GetListBus;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, busList())
            .commit()
    }
}