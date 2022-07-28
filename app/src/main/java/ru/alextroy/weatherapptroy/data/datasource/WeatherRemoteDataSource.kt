package ru.alextroy.weatherapptroy.data.datasource

import ru.alextroy.weatherapptroy.data.dto.WeatherResponseDto
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse
import javax.inject.Inject

open class WeatherRemoteDataSource @Inject constructor(): Mapper<WeatherResponse, WeatherResponseDto> {

    override fun mapFromEntity(type: WeatherResponse): WeatherResponseDto {
        return WeatherResponseDto(type.current, type.location)
    }

    override fun mapToEntity(type: WeatherResponseDto): WeatherResponse {
        return WeatherResponse(type.current, type.location)
    }


}