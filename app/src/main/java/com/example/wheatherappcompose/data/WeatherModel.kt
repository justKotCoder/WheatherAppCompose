package com.example.wheatherappcompose.data

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val icon: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val hours:String
)
