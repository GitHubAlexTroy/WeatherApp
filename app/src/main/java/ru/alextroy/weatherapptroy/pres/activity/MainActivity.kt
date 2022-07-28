package ru.alextroy.weatherapptroy.pres.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.alextroy.weatherapptroy.pres.viewmodel.WeatherViewModel
import ru.alextroy.weatherapptroy.ui.theme.WeatherAppTroyTheme

const val API_KEY = "50d0ab1d632f4594a8e182921222206"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTroyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WeatherData()
                }
            }
        }
    }
}

@Composable
private fun WeatherData(viewModel: WeatherViewModel = viewModel()) {
    val list = viewModel.invoke().collectAsState(null)
    Text(text = list.value?.current?.feelslike_c.toString())
}
