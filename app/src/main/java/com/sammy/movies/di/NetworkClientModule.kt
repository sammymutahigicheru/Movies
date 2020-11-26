package com.sammy.movies.di

import com.sammy.datasource.NetworkClient
import org.koin.dsl.module

val networkClientModule = module {
    single { NetworkClient<Any>(get()) }
}