package ru.alextroy.weatherapptroy.data.dto

data class WeatherResponseDto(
    val current: CurrentDto,
    val location: LocationDto
) {

}