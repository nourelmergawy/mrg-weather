package com.mrg.weather.di

import com.mrg.weather.data.location.DefaultLocationTracker
import com.mrg.weather.data.repoitrory.WeatherRepositroyImpl
import com.mrg.weather.location.LocationTracker
import com.mrg.weather.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton
@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositroyImpl: WeatherRepositroyImpl):WeatherRepository
}