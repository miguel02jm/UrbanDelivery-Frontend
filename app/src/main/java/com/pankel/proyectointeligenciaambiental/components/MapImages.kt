package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pankel.proyectointeligenciaambiental.R

@Composable
fun MapImages(id: String, index: Int, salida: String?, llegada: String?, posRobot: String?){

    val salidaIndex = salida?.toIntOrNull() ?: 35
    val llegadaIndex = llegada?.toIntOrNull() ?: 35
    val posRobotIndex = posRobot?.toIntOrNull() ?: -1

    val imageResource = when (id) {
        "01" -> R.drawable._01
        "02" -> R.drawable._02
        "03" -> R.drawable._03
        "04" -> R.drawable._04
        "05" -> R.drawable._05
        "06" -> R.drawable._06
        "07" -> R.drawable._07
        "08" -> R.drawable._08
        "09" -> R.drawable._09
        "10" -> R.drawable._10
        "11" -> R.drawable._11
        else -> R.drawable._00
    }

    val imageResource2 = when (index) {
        salidaIndex -> R.drawable.greenflag
        llegadaIndex -> R.drawable.redflag
        posRobotIndex -> R.drawable.robot
        else -> imageResource
    }

    val imageResource3 = when (index) {
        posRobotIndex -> R.drawable.robot
        else -> imageResource2
    }

    Image(painter = painterResource(id = imageResource), contentDescription = "Image")
    Image(painter = painterResource(id = imageResource2), contentDescription = "Image2")
    Image(painter = painterResource(id = imageResource3), contentDescription = "Image3")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd){
        Text(text = index.toString(), modifier = Modifier.padding(end = 5.dp), color = Color.Black)
    }
}