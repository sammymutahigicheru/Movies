package com.sammy.movies.base

import com.sammy.movies.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivityComponent:AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}