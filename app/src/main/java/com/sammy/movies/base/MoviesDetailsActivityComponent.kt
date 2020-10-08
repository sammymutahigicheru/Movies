package com.sammy.movies.base

import com.sammy.movies.details.MovieDetailsActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MoviesDetailsActivityComponent: AndroidInjector<MovieDetailsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsActivity>()
}