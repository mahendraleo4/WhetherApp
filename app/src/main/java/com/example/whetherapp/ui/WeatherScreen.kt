package com.example.whetherapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import com.example.whetherapp.viewModel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weather by viewModel.weather.observeAsState()

    Column {
        Text(text = "Weather in ${weather?.name}")
        // Display other weather data...
    }
}

