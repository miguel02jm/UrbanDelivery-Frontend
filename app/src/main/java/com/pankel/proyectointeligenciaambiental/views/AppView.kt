package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.components.AddOrder
import com.pankel.proyectointeligenciaambiental.components.Map
import com.pankel.proyectointeligenciaambiental.components.OrderList
import com.pankel.proyectointeligenciaambiental.state.AppState
import com.pankel.proyectointeligenciaambiental.ui.theme.background
import com.pankel.proyectointeligenciaambiental.ui.theme.background2
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@Composable
fun AppView(appState: AppState, navController: NavController, appViewModel: AppViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(background2),
            contentAlignment = Alignment.Center
        ) {
            OrderList(appViewModel)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(background),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Map(appState = appState)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                AddOrder(navController)
            }
        }
    }
}


