package com.sammy.movies.base.builder

import androidx.lifecycle.ViewModel
import com.sammy.movies.ui.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MoviesViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: MoviesViewModel): ViewModel
}