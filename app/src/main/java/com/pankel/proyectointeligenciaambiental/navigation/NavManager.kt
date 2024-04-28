package com.pankel.proyectointeligenciaambiental.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pankel.proyectointeligenciaambiental.state.AppState
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel
import com.pankel.proyectointeligenciaambiental.views.AddOrderView
import com.pankel.proyectointeligenciaambiental.views.AppView

@Composable
fun NavManager(appState: AppState, appViewModel: AppViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "AppView"){
        composable("AppView"){
            AppView(appState = appState, navController, appViewModel)
        }
        composable("AddOrderView"){
            AddOrderView(appState = appState, navController, appViewModel)
        }
    }
}