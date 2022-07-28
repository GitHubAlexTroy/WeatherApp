package ru.alextroy.weatherapptroy.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alextroy.weatherapptroy.data.api.WeatherApi
import ru.alextroy.weatherapptroy.data.datasource.WeatherRemoteDataSource
import ru.alextroy.weatherapptroy.data.dto.WeatherResponseDto
import ru.alextroy.weatherapptroy.data.repository.WeatherRepositoryImpl
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse
import ru.alextroy.weatherapptroy.data.datasource.Mapper
import javax.inject.Singleton

private const val BASE_URL = "http://api.weatherapi.com/v1/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkService(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideWeatherRepository(
        api: WeatherApi,
        dataSource: WeatherRemoteDataSource
    ): WeatherRepositoryImpl =
        WeatherRepositoryImpl(api, dataSource)

//    @Provides
//    fun provideWeatherRemoteDataSource() =
//        WeatherRemoteDataSource()
}