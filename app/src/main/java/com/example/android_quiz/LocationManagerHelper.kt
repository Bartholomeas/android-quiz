// LocationManagerHelper.kt
package com.example.android_quiz.app

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import java.text.SimpleDateFormat
import java.util.*

class LocationManagerHelper(private val context: Context) {

    private var locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun startLocationUpdates(locationListener: LocationListener) {
        locationManager = (context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?)!!
        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000,
            1.0f,
            locationListener
        )
    }

    fun stopLocationUpdates(locationListener: LocationListener) {
        locationManager?.removeUpdates(locationListener)
    }

    fun getCurrentTimeInTimeZone(timeZone: String): String {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(timeZone)
        return sdf.format(Date())
    }
}
