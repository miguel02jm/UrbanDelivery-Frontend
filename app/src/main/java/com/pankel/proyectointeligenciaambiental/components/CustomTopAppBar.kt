package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pankel.proyectointeligenciaambiental.ui.theme.background2

@Composable
fun CustomTopAppBar(title: String, onClickBackButton: () -> Unit){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = background2,
            titleContentColor = Color.White
        ),
        title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = title, maxLines = 1)
            }
        },
        navigationIcon = {
            IconButton(onClick = onClickBackButton) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
        }
        )
}