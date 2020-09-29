package com.sammy.movies.base.builder

import com.sammy.movies.base.MoviesFragmentBuilder
import com.sammy.movies.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{
   @ContributesAndroidInjector(
       modules = [
       MoviesFragmentBuilder::class,
       MoviesViewModelBuilder::class
       ]
   )
   internal abstract fun bindMainActivity(): MainActivity
}