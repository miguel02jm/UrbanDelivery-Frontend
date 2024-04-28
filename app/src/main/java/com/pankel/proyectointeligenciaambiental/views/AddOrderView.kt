package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.components.customTextField
import com.pankel.proyectointeligenciaambiental.state.AppState
import com.pankel.proyectointeligenciaambiental.ui.theme.background
import com.pankel.proyectointeligenciaambiental.ui.theme.buttonColor
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@Composable
fun AddOrderView(appState: AppState, navController: NavController, appViewModel: AppViewModel) {
    Box(
        modifier = Modifier
            .background(background)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var text by remember { mutableStateOf("Hello") }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            customTextField(
                value = appState.salida,
                onValueChange = { appState.salida = it },
                label = "Salida"
            )
            customTextField(
                value = appState.llegada,
                onValueChange = { appState.llegada = it },
                label = "Llegada"
            )
            Button(
                onClick = {appViewModel.agregarSalidaLlegada(appState.salida, appState.llegada)
                          navController.navigate("AppView")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = Color.Black
                ),
                modifier = Modifier.width(250.dp)
            ) {
                Text(text = "Confirmar Pedido", fontSize = 24.sp)
            }
        }
    }
}