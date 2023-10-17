package com.example.whetherapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.whetherapp.di.ViewModelActivity
import com.example.whetherapp.viewModel.WeatherViewModel

class MainActivity : ViewModelActivity() {
    private val viewModel: WeatherViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherScreen(viewModel)
        }
        viewModel.getCurrentWeather("Pune")
    }
}