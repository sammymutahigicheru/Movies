package com.sammy.movies.base

import android.app.Application
import com.sammy.datasource.NetworkModule
import com.sammy.movies.base.viewmodel.ViewModelBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ViewModelBuilder::class
    ]
)
interface AppComponent:AndroidInjector<DaggerApplication> {
    fun inject(app:MyApplication)
    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}