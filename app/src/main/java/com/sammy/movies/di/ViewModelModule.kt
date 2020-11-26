package com.sammy.movies.di

import com.sammy.movies.details.MovieDetailsViewModel
import com.sammy.movies.ui.MoviesViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        MoviesViewModel(get())
    }
    viewModel{
        MovieDetailsViewModel(get(),get(),get())
    }
}