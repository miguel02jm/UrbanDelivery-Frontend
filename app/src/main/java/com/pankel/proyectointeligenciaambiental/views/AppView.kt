package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.R
import com.pankel.proyectointeligenciaambiental.components.AddOrder
import com.pankel.proyectointeligenciaambiental.components.Map
import com.pankel.proyectointeligenciaambiental.components.OrderList
import com.pankel.proyectointeligenciaambiental.ui.theme.background
import com.pankel.proyectointeligenciaambiental.ui.theme.background2
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel
import kotlinx.coroutines.delay

@Composable
fun AppView(navController: NavController, appViewModel: AppViewModel) {

    var showAlert by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Row(modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 5.dp)) {
                    IconButton(
                        onClick = {showAlert = true},
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.helpicon),
                            contentDescription = "HelpIcon",
                            tint = Color.Gray
                        )
                    }
                }
                Map(appViewModel)
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
    if(showAlert){
        AlertDialogExample(
            onConfirmation = {
                showAlert = false
            },
            dialogTitle = "LEYENDA ICONOS",
        )
    }
}


@Composable
fun AlertDialogExample(
    onConfirmation: () -> Unit,
    dialogTitle: String,
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Box() {
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.greenflag),
                            contentDescription = "Image",
                            modifier = Modifier.size(85.dp)
                        )
                        Text(text = "Salida del pedido")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.redflag),
                            contentDescription = "Image",
                            modifier = Modifier.size(85.dp)
                        )
                        Text(text = "Llegada del pedido")
                    }
                }
            }
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("De acuerdo")
            }
        }
    )
}



