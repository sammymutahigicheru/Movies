package com.sammy.movies.di

import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
* Using an object rather than a class leads to less generated code
* */

val networkModule = module {

    single { provideMoviesService(retrofit = get()) }

    single { provideRetrofit(okHttpClient = get(), url = BASE_URL) }

    single { provideOkHttpClient() }
}

internal fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

internal fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

internal fun provideMoviesService(retrofit: Retrofit): MoviesApi =
    retrofit.create(MoviesApi::class.java)