package com.sammy.movies.base

import com.sammy.movies.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{
   @ContributesAndroidInjector(
       modules = [
       MoviesFragmentBuilder::class
       ]
   )
   internal abstract fun bindMainActivity(): MainActivity
}