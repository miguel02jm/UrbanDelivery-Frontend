package com.pankel.proyectointeligenciaambiental.repository

import com.pankel.proyectointeligenciaambiental.data.DataApi
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import javax.inject.Inject

class DataRepository @Inject constructor(private val dataApi: DataApi) {
    suspend fun getData(): String? {
        return try {
            val response = dataApi.getData()
            if (response.isSuccessful) {
                response.body()
            } else {
                throw Exception("Error al obtener los datos: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            throw Exception("Error de red al obtener los datos: ${e.message}")
        }
    }

    suspend fun sendData(salidaLlegada: SalidaLlegada) {
        try {
            val response = dataApi.sendData(salidaLlegada)
            if (response.isSuccessful) {
            } else {
                throw Exception("Error al enviar los datos: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            throw Exception("Error de red al enviar los datos: ${e.message}")
        }
    }
}
