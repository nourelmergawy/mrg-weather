package com.mrg.weather.data.repoitrory

import android.os.Build
import androidx.annotation.RequiresApi
import com.mrg.weather.data.mappers.toWeatherInfo
import com.mrg.weather.data.remote.WeatherApi
import com.mrg.weather.repository.WeatherRepository
import com.mrg.weather.utlis.Resource
import com.mrg.weather.utlis.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositroyImpl@Inject constructor(
    private val api :WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
   return try {
       Resource.Success(
           data = api.getWeatherData(
               lat= lat,
               long = long
           ).toWeatherInfo()
       )
   }catch (e:Exception){
       e.printStackTrace()
       Resource.Error(e.message?:"An unkown error occurred.",data = null)
   }
    }
}