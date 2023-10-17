package com.example.whetherapp.di

import android.app.Application
import com.example.whetherapp.TheWeatherApplication
import com.example.whetherapp.annotations.AppScope
import com.example.whetherapp.ui.module.WeatherModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component (
    modules = [
        AndroidInjectionModule::class,
        WeatherModule::class]
        )

interface AppComponent : AndroidInjector<DaggerApplication> {

//    @Component.Factory
//    interface Factory {
//        @AppScope
//        fun create(application: DaggerApplication): AppComponent
//
//       // fun inject(mainActivity: MainActivity)
//    }


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        @AppScope
        fun build(): AppComponent
    }
    @AppScope
    fun inject(application: TheWeatherApplication)
}