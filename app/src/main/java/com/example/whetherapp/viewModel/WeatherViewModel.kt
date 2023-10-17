package com.example.whetherapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whetherapp.data.WeatherResponse
import com.example.whetherapp.domain.GetCityWhetherUseCase
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

open class WeatherViewModel @Inject constructor(
    private val getCityWhetherUseCase: GetCityWhetherUseCase
) : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse>()

    val weather : LiveData<WeatherResponse> get() = _weather

    fun getCurrentWeather(city: String) {

        val params = GetCityWhetherUseCase.Params(
            city = city,
            apiKey = "8df3f2c0c926f22ffd29638c0780e2f0"
        )

        getCityWhetherUseCase.build(params)
            .onEach {
                // success
                _weather.value = it
            }
    }
}