package com.pankel.proyectointeligenciaambiental.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada

class AppViewModel: ViewModel() {
    private val _listaSalidasLlegadas = mutableStateListOf<SalidaLlegada>()
    val listaSalidasLlegadas: List<SalidaLlegada> = _listaSalidasLlegadas

    init {
        _listaSalidasLlegadas.add(SalidaLlegada("10", "23"))
        _listaSalidasLlegadas.add(SalidaLlegada("17", "09"))
        _listaSalidasLlegadas.add(SalidaLlegada("04", "02"))
        _listaSalidasLlegadas.add(SalidaLlegada("16", "07"))
    }

    fun agregarSalidaLlegada(salida: String, llegada: String){
        _listaSalidasLlegadas.add(SalidaLlegada(salida, llegada))
    }
}