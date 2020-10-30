package com.sammy.movies.base

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication: DaggerApplication(),MovieDetailsProvider {
    val appComponent = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }

    override fun provideMovieDetailsComponent(): MovieDetailsComponent = appComponent.movieDetailsComponent().create()

}