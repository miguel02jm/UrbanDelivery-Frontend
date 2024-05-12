package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.R
import com.pankel.proyectointeligenciaambiental.components.CustomTopAppBar
import com.pankel.proyectointeligenciaambiental.components.customTextField
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
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
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.padding(top = 100.dp),
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
                        appViewModel.listaSalidasLlegadas.add(
                            SalidaLlegada(
                                appViewModel.salida.value,
                                appViewModel.llegada.value
                            )
                        )
                        appViewModel.salida.value = ""
                        appViewModel.llegada.value = ""
                        navController.navigate("AppView")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor,
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .padding(top = 15.dp)
                ) {
                    Text(text = "Confirmar Pedido", fontSize = 20.sp, color = Color.Black)
                }
                Image(modifier = Modifier.padding(top = 100.dp), painter = painterResource(id = R.drawable.logistics_delivery), contentDescription = "DeliveryIcon")
            }
        }
    }
}