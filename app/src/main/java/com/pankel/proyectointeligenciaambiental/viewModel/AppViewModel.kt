package com.pankel.proyectointeligenciaambiental.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import com.pankel.proyectointeligenciaambiental.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repo: DataRepository): ViewModel() {
    private val _salida = mutableStateOf("")
    var salida: MutableState<String> = _salida
    private val _llegada = mutableStateOf("")
    var llegada: MutableState<String> = _llegada

    private val _listaSalidasLlegadas = mutableStateListOf<SalidaLlegada>()
    var listaSalidasLlegadas: MutableList<SalidaLlegada> = _listaSalidasLlegadas

    private val _mapaCode = mutableStateOf("")
    var mapaCode: MutableState<String> = _mapaCode

    private val _listaIdMapa = mutableStateListOf<String>()
    var listaIdMapa: MutableList<String> = _listaIdMapa

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val result = repo.getData()
                _mapaCode.value = result ?: ""
            } catch (e: Exception) {
                Log.e("TestViewModel", "Error al obtener datos: ${e.message}", e)
            }
        }
    }

    fun enviarSalidaLlegada(salida: String, llegada: String) {
        val salidaLlegada = SalidaLlegada(salida, llegada)
        viewModelScope.launch {
            try {
                repo.sendData(salidaLlegada)
                salidaLlegada.enviado = true
            } catch (e: Exception) {
            }
        }
    }

    fun eliminarSalidaLlegada(salidaLlegada: SalidaLlegada) {
        _listaSalidasLlegadas.remove(salidaLlegada)
    }
}