package com.example.whetherapp

import com.example.whetherapp.data.Main
import com.example.whetherapp.data.Weather
import com.example.whetherapp.data.WeatherResponse
import com.example.whetherapp.domain.GetCityWhetherUseCase
import com.example.whetherapp.nwtwork.WeatherApi
import com.example.whetherapp.viewModel.WeatherViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class WeatherViewModelTest {

    @Mock
    lateinit var weatherApi: GetCityWhetherUseCase

    lateinit var viewModel: WeatherViewModel

    @Before
    fun setup() {
        viewModel = WeatherViewModel(weatherApi)
    }

    @Test
    fun getCurrentWeather_success() {
        // Arrange
        val call: Call<WeatherResponse> = Mockito.mock(Call::class.java) as Call<WeatherResponse>
        val response: Response<WeatherResponse> = Response.success(getWeatherResponse())
        Mockito.`when`(viewModel.getCurrentWeather("city")).thenReturn(Unit)
        Mockito.`when`(call.execute()).thenReturn(response)

        // Act
        viewModel.getCurrentWeather("city")

        // Assert
        Assert.assertNotNull(viewModel.weather.value)
    }

    private fun getWeatherResponse () : WeatherResponse {
        return WeatherResponse(
            name = "name",
            main = Main(
                temp = 1,
                feels_like = 2,
                temp_min = 24,
                temp_max = 30,
                pressure = 35,
                humidity = 40
            ),
            weather = listOf(
                Weather(
                    main = "main",
                    description = "description"
                ),
                Weather(
                    main = "main",
                    description = "description"
                ),
            ),
            id = 1
        )
    }
}