package com.sammy.movies

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        //timber
        // stetho
        //crashanalyticstree
    }
}