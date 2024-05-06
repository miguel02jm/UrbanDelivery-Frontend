package com.pankel.proyectointeligenciaambiental.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import com.pankel.proyectointeligenciaambiental.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repo: DataRepository): ViewModel() {
    private val _salida = mutableStateOf("")
    var salida: MutableState<String> = _salida
    private val _llegada = mutableStateOf("")
    var llegada: MutableState<String> = _llegada

    private val _listaSalidasLlegadas = mutableStateListOf<SalidaLlegada>()
    var listaSalidasLlegadas: List<SalidaLlegada> = _listaSalidasLlegadas

    private val _mapaCode = mutableStateOf("")
    var mapaCode: MutableState<String> = _mapaCode

    private val _listaIdMapa = mutableStateListOf<String>()
    var listaIdMapa: MutableList<String> = _listaIdMapa

    init {
        _listaSalidasLlegadas.add(SalidaLlegada("10", "23"))
        _listaSalidasLlegadas.add(SalidaLlegada("17", "09"))
        _listaSalidasLlegadas.add(SalidaLlegada("04", "02"))
    }

    fun agregarSalidaLlegada(salida: String, llegada: String){
        _listaSalidasLlegadas.add(SalidaLlegada(salida, llegada))
    }

    fun eliminarSalidaLlegada(){
        _listaSalidasLlegadas.removeFirst()
    }
}