package ru.alextroy.weatherapptroy.domain.entities

import ru.alextroy.weatherapptroy.data.dto.CurrentDto
import ru.alextroy.weatherapptroy.data.dto.LocationDto

data class WeatherResponse(
    val current: CurrentDto,
    val location: LocationDto
)