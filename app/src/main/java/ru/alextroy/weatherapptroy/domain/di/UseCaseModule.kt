package ru.alextroy.weatherapptroy.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alextroy.weatherapptroy.data.repository.WeatherRepositoryImpl
import ru.alextroy.weatherapptroy.domain.WeatherUseCase
import ru.alextroy.weatherapptroy.domain.WeatherUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideWeatherUseCase(weatherRepository: WeatherRepositoryImpl): WeatherUseCase =
        WeatherUseCaseImpl(weatherRepository)
}