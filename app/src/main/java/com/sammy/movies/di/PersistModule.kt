package com.sammy.movies.di

import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.genre.GenrePersist
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.MoviePersist
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.datasource.cache.reviews.ReviewPersist
import com.sammy.datasource.cache.reviews.ReviewResponse
import com.sammy.datasource.cache.trailer.TrailerPersist
import com.sammy.datasource.cache.trailer.TrailerResponse
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val persistModule = module {
    single<CacheInterface<GenreResponse>> { GenrePersist(androidContext()) }
    single<CacheInterface<MoviesResponse>> { MoviePersist(androidContext()) }
    single<CacheInterface<ReviewResponse>> { ReviewPersist(androidContext()) }
    single<CacheInterface<TrailerResponse>> { TrailerPersist(androidContext()) }
}