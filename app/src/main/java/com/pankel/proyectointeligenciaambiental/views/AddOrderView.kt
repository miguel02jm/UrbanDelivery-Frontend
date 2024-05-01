package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.components.CustomTopAppBar
import com.pankel.proyectointeligenciaambiental.components.customTextField
import com.pankel.proyectointeligenciaambiental.ui.theme.background
import com.pankel.proyectointeligenciaambiental.ui.theme.buttonColor
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrderView(navController: NavController, appViewModel: AppViewModel) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Añadir nueva Entrega",
                onClickBackButton = {
                    navController.navigateUp()
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .background(background)
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                customTextField(
                    value = appViewModel.salida.value,
                    onValueChange = { appViewModel.salida.value = it },
                    label = "Salida"
                )
                customTextField(
                    value = appViewModel.llegada.value,
                    onValueChange = { appViewModel.llegada.value = it },
                    label = "Llegada"
                )
                Button(
                    onClick = {
                        appViewModel.agregarSalidaLlegada(appViewModel.salida.value, appViewModel.llegada.value)
                        navController.navigate("AppView")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor,
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Confirmar Pedido", fontSize = 24.sp, color = Color.Black)
                }
            }
        }
    }
}