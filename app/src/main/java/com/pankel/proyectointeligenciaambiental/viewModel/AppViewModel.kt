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
import kotlinx.coroutines.delay
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

    private val _posRobot = mutableStateOf("")
    var posRobot: MutableState<String> = _posRobot

    init {
        fetchMapaCode()
        fetchCodeRobot()
    }

    private fun fetchMapaCode() {
        viewModelScope.launch {
            try {
                val result = repo.getMapaCode()
                _mapaCode.value = result?.mapaCode.toString()
                val list = mapaCode.value.chunked(2)
                listaIdMapa.clear()
                listaIdMapa.addAll(list)
            } catch (e: Exception) {
                Log.e("AppViewModel", "Error al obtener datos: ${e.message}", e)
            }
        }
    }

    private fun fetchCodeRobot() {
        viewModelScope.launch {
            viewModelScope.launch {
                while (true) {
                    try {
                        val result = repo.getPosRobot()
                        _posRobot.value = result?.posRobot.toString()
                    } catch (e: Exception) {
                        Log.e("AppViewModel", "Error al obtener datos: ${e.message}", e)
                    }
                    delay(2500)
                }
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
                Log.e("AppViewModel", "Error al enviar los datos: ${e.message}", e)
            }
        }
    }

    fun eliminarSalidaLlegada(salidaLlegada: SalidaLlegada) {
        _listaSalidasLlegadas.remove(salidaLlegada)
    }
}