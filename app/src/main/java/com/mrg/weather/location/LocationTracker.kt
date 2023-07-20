package com.mrg.weather.location

import android.location.Location

interface LocationTracker {
    suspend fun getCrrentLocation() :Location?
}