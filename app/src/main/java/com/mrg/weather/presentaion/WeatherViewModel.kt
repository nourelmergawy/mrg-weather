package com.mrg.weather.presentaion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrg.weather.location.LocationTracker
import com.mrg.weather.repository.WeatherRepository
import com.mrg.weather.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
):ViewModel(){
    var state by mutableStateOf(WeatherState())
    private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state =state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCrrentLocation()?.let { location ->
                when(val result = repository.getWeatherData(location.latitude,location.altitude)){
                    is Resource.Success ->{
                        state =state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error ->{
                        state =state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }?: kotlin.run {
                state =state.copy(
                    isLoading = false,
                    error = "couldn't retrive location make sure to grant permission and gps"
                )
            }
        }

    }
}