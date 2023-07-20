package com.mrg.weather.repository

import com.mrg.weather.utlis.Resource
import com.mrg.weather.utlis.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long :Double):Resource<WeatherInfo>
}