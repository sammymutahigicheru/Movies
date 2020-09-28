package com.sammy.movies.base

import com.sammy.movies.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesFragmentBuilder {
    @ContributesAndroidInjector
    abstract fun bindMoviesFragment(): MoviesFragment
}