package ru.alextroy.weatherapptroy.pres.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.alextroy.weatherapptroy.domain.WeatherUseCaseImpl
import ru.alextroy.weatherapptroy.domain.entities.WeatherResponse
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCaseImpl
) : ViewModel() {

    fun invoke(): Flow<WeatherResponse> = weatherUseCase.invoke()
}