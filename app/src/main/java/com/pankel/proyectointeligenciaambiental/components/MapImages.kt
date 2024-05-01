package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.pankel.proyectointeligenciaambiental.R
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@Composable
fun MapImages(id: String, index: Int, salida: String?, llegada: String?){

    val salidaIndex = if (salida.isNullOrEmpty()) 35 else salida.toInt()
    val llegadaIndex = if (llegada.isNullOrEmpty()) 35 else llegada.toInt()

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
        else -> imageResource
    }


    Image(painter = painterResource(id = imageResource), contentDescription = "Image")
    Image(painter = painterResource(id = imageResource2), contentDescription = "Image2")
}