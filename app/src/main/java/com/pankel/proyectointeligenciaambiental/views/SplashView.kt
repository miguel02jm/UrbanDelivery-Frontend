package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pankel.proyectointeligenciaambiental.ui.theme.background
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(5000)
        navController.popBackStack()
        navController.navigate("AppView")
    }
    Splash()
}

@Composable
fun Splash(){
    Box(modifier = Modifier.background(background).fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = com.pankel.proyectointeligenciaambiental.R.drawable.delivery),
                contentDescription = "DeliveryLogo",
            )
            Text(modifier = Modifier.padding(20.dp), text = "Proyecto Inteligencia Ambiental", fontSize = 18.sp)
        }
    }
}