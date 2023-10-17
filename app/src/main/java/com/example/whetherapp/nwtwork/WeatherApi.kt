package com.example.whetherapp.nwtwork

import com.example.whetherapp.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(@Query("q") city: String, @Query("appid") apiKey: String): WeatherResponse
}