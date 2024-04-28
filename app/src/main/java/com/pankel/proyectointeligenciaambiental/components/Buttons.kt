package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.ui.theme.buttonColor

@Composable
fun AddOrder(navController: NavController){
    FloatingActionButton(
        onClick = { navController.navigate("AddOrderView")},
        containerColor = buttonColor
    ) {
       Icon(imageVector = Icons.Filled.Add, contentDescription = "Add a new Order", tint = Color.Black)
    }
}