package ru.alextroy.weatherapptroy.domain

import kotlinx.coroutines.flow.Flow
import ru.alextroy.weatherapptroy.data.dto.WeatherResponseDto
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse


interface WeatherUseCase {

    fun invoke(): Flow<WeatherResponse>

}