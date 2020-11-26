package com.sammy.movies.di

import com.sammy.datasource.datasource.GenreDataSource
import com.sammy.datasource.datasource.MovieDataSource
import com.sammy.datasource.datasource.ReviewDatasource
import com.sammy.datasource.datasource.TrailerDatasource
import org.koin.dsl.module

val dataSourceModule = module {
    single { GenreDataSource(get(),get()) }
    single { MovieDataSource(get(),get()) }
    single { ReviewDatasource(get(),get()) }
    single { TrailerDatasource(get(),get()) }
}