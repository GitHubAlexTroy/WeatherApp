package ru.alextroy.weatherapptroy.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.alextroy.weatherapptroy.data.dto.WeatherResponseDto
import ru.alextroy.weatherapptroy.pres.activity.API_KEY

interface WeatherApi {

    @GET("current.json")
    suspend fun getWeather(
        @Query("q")
        city: String = "Moscow",
        @Query("key")
        apiKey: String = API_KEY
    ): WeatherResponseDto

}

