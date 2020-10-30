package com.sammy.movies.base

import com.sammy.movies.details.MovieDetailsActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MovieDetailsComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieDetailsComponent
    }

    fun inject(movieDetailsActivity: MovieDetailsActivity)
}