package com.example.whetherapp

import android.app.Activity
import android.os.Build.FINGERPRINT
import com.example.whetherapp.annotations.AppScope
import com.example.whetherapp.di.AppComponent
import com.example.whetherapp.di.DaggerAppComponent
import com.example.whetherapp.di.Injector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.internal.MapFactory.builder
import dagger.internal.MapProviderFactory.builder
import dagger.internal.SetFactory.builder
import java.util.stream.DoubleStream.builder
import java.util.stream.Stream.builder
import javax.inject.Inject

@AppScope
@Suppress("unused")
class TheWeatherApplication : DaggerApplication() {

  private var appComponent :AppComponent ? = null

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


  override fun onCreate() {
    super.onCreate()
   // DaggerAppComponent.factory().create().inject(this)
   // appComponent =  DaggerAppComponent.factory().create()


    Injector.provideComponent(appComponent)
    DaggerAppComponent.builder().application(this).build().inject(this)
  }

  private fun isRobolectricUnitTest(): Boolean {
    return "robolectric" == FINGERPRINT
  }

  override fun androidInjector(): DispatchingAndroidInjector<Any> {
    return dispatchingAndroidInjector
  }

  override fun applicationInjector() = appComponent
}