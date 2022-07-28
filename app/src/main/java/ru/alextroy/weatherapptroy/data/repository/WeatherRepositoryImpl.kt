package ru.alextroy.weatherapptroy.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.alextroy.weatherapptroy.data.api.WeatherApi
import ru.alextroy.weatherapptroy.data.datasource.WeatherRemoteDataSource
import ru.alextroy.weatherapptroy.domain.WeatherRepository
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse
import ru.alextroy.weatherapptroy.pres.activity.API_KEY
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val remoteDataSource: WeatherRemoteDataSource,
) : WeatherRepository {

    override fun invoke(): Flow<WeatherResponse> =
        flow {
            val list = api.getWeather("Moscow", API_KEY)
            emit(list)
        }.map {
            remoteDataSource.mapToEntity(it)
        }
}