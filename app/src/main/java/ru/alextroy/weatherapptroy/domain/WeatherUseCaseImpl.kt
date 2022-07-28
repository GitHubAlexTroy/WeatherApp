package ru.alextroy.weatherapptroy.domain

import kotlinx.coroutines.flow.Flow
import ru.alextroy.weatherapptroy.data.repository.WeatherRepositoryImpl
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse
import javax.inject.Inject

class WeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepositoryImpl
) : WeatherUseCase {

    override fun invoke(): Flow<WeatherResponse> {
        return repository.invoke()
    }
}