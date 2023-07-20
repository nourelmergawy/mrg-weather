package com.mrg.weather.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.mrg.weather.data.remote.WeatherDataDto
import com.mrg.weather.data.remote.WeatherDto
import com.mrg.weather.utlis.weather.WeatherData
import com.mrg.weather.utlis.weather.WeatherInfo
import com.mrg.weather.utlis.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class IndexWeatherData(
    val index : Int,
    val data : WeatherData
)


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap():Map<Int,List<WeatherData>>{
return time.mapIndexed { index, time ->
    val temperature = temperatures[index]
    val weatherCode = weatherCodes[index]
    val windSpeed =  windSpeeds[index]
    val pressure =pressures[index]
    val humiditiy =humidities[index]
    IndexWeatherData(
        index = index,
        data = WeatherData(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperatureCelsius =temperature,
            pressure = pressure,
            windSpeed =windSpeed,
            humidity = humiditiy,
            weatherType = WeatherType.fromWMO(weatherCode)
        )
    )
}.groupBy {
    it.index / 24
}.mapValues {
    it.value.map { it.data }
}.also { print(it) }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo():WeatherInfo{
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute< 30) now.hour else now.hour +1
        it.time.hour == hour
    }
    return  WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )

}