package com.pankel.proyectointeligenciaambiental.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada

class AppState {
    var salida by mutableStateOf("")
    var llegada by mutableStateOf("")
    var listaEntradasSalidas = mutableListOf<SalidaLlegada>()

    var mapaCode by mutableStateOf("")
    var listaIdMapa = mutableListOf<String>()
}