package com.sammy.movies.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MainActivityComponent::class,
MoviesDetailsActivityComponent::class
]

)
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }
}