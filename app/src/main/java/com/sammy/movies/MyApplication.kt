package com.sammy.movies

import android.app.Application
import com.sammy.movies.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        //timber
        // stetho
        //crashanalyticstree
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                viewModelModule,
                dataSourceModule,
                networkClientModule,
                persistModule
            )
        }
    }
}