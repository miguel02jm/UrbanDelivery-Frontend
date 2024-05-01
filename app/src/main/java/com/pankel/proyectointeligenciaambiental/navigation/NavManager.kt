package com.pankel.proyectointeligenciaambiental.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel
import com.pankel.proyectointeligenciaambiental.views.AddOrderView
import com.pankel.proyectointeligenciaambiental.views.AppView

@Composable
fun NavManager(appViewModel: AppViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "AppView"){
        composable("AppView"){
            AppView(navController, appViewModel)
        }
        composable("AddOrderView"){
            AddOrderView(navController, appViewModel)
        }
    }
}