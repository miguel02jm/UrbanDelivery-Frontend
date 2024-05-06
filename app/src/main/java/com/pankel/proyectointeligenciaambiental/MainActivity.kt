package com.pankel.proyectointeligenciaambiental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pankel.proyectointeligenciaambiental.navigation.NavManager
import com.pankel.proyectointeligenciaambiental.ui.theme.ProyectoInteligenciaAmbientalTheme
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel
import com.pankel.proyectointeligenciaambiental.viewModel.TestViewModel
import com.pankel.proyectointeligenciaambiental.views.TestView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val AppViewModel: AppViewModel by viewModels()
            //val TestViewModel: TestViewModel by viewModels()

            ProyectoInteligenciaAmbientalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(AppViewModel)
                    //TestView(TestViewModel)
                }
            }
        }
    }
}