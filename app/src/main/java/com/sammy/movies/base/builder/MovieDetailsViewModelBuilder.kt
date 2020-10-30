package com.sammy.movies.base.builder

import androidx.lifecycle.ViewModel
import com.sammy.movies.details.MovieDetailsViewModel
import com.sammy.movies.ui.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieDetailsViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: MovieDetailsViewModel): ViewModel
}