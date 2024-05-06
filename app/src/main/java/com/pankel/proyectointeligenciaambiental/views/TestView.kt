package com.pankel.proyectointeligenciaambiental.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.pankel.proyectointeligenciaambiental.viewModel.TestViewModel

@Composable
fun TestView(testViewModel: TestViewModel){
    val datos by testViewModel.datos.collectAsState()// Obtener el valor actual del StateFlow

    LazyColumn {
        items(datos) {item ->
            Text(text = item.toString() )
        }
    }
}