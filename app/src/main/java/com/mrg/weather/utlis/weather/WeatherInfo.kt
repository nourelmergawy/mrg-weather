package com.mrg.weather.utlis.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int,List<WeatherData>,
    val currentWeatherData :WeatherData?
)
