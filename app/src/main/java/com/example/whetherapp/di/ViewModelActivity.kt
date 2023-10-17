package com.example.whetherapp.di

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

/**
 * ViewModelActivity is an abstract class for request dependency injection and
 * provides implementations of [ViewModel] and [ViewDataBinding] from an abstract information.
 * Do not modify this class. This is a first-level abstraction class.
 * If you want to add more specifications, make another class which extends [ViewModelActivity].
 */
abstract class ViewModelActivity : DaggerAppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  protected inline fun <reified VM : ViewModel>
    injectViewModels(): Lazy<VM> = viewModels { viewModelFactory }

}