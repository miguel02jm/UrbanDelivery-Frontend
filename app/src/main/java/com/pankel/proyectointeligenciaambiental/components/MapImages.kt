package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.pankel.proyectointeligenciaambiental.R

@Composable
fun MapImages(id: String, index: Int){

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

    Image(painter = painterResource(id = imageResource), contentDescription = "Image")
}