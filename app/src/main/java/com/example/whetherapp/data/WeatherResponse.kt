package com.example.whetherapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class WeatherResponse(
    @SerializedName("name") val name: String,
    @SerializedName("main") val main: Main,
    @SerializedName("weather") val weather: List<Weather>,
   // @SerializedName("sys") val sys: Sys,
    @SerializedName("dt") val dt: Long,
    @SerializedName("id") val id: Int,
   // @SerializedName("coord") val coord: Coord
) : Parcelable

@Parcelize
data class Main(
    @SerializedName("temp") val temp: Int,
    @SerializedName("feels_like") val feels_like: Int,
    @SerializedName("temp_min") val temp_min: Int,
    @SerializedName("temp_max") val temp_max: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
): Parcelable

@Parcelize
data class Weather(
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: Int
): Parcelable