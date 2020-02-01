package com.example.simpleloadersample

import android.app.Application
import com.example.simpleloadersample.di.AppComponent
import com.example.simpleloadersample.di.DaggerAppComponent


class App : Application() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .applicationContext(applicationContext)
                .build()

    }
}