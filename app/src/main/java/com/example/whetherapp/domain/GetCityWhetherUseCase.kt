package com.example.whetherapp.domain

import com.example.whetherapp.data.WeatherResponse
import com.example.whetherapp.foundation.BaseUseCase
import com.example.whetherapp.foundation.flowSingle
import com.example.whetherapp.nwtwork.WeatherApi
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityWhetherUseCase @Inject constructor(
    private val whetherApi: WeatherApi
) : BaseUseCase<GetCityWhetherUseCase.Params, WeatherResponse>(){

    data class Params(
        @SerializedName("city")
        val city: String,
        @SerializedName("apiKey")
        val apiKey: String,
    )

    override fun onBuild(params: Params): Flow<WeatherResponse> {
        return flowSingle {
            whetherApi.getCurrentWeather(params.city, params.apiKey)
        }
    }
}

