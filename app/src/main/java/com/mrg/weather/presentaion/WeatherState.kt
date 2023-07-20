package com.mrg.weather.presentaion

import com.mrg.weather.utlis.weather.WeatherInfo

data class WeatherState(

    val weatherInfo: WeatherInfo?= null,
    val isLoading :Boolean= false,
    val error: String?= null
)
