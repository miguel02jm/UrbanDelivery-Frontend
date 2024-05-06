package com.pankel.proyectointeligenciaambiental.repository

import com.google.gson.JsonParseException
import com.pankel.proyectointeligenciaambiental.data.DataApi
import com.pankel.proyectointeligenciaambiental.model.datos
import java.io.IOException
import javax.inject.Inject

class DataRepository @Inject constructor(private val dataApi: DataApi) {

    suspend fun getData(): List<Int>? {
        return try {
            val response = dataApi.getData()
            if (response.isSuccessful) {
                response.body()
            } else {
                throw Exception("Error al obtener los datos: ${response.code()} - ${response.message()}")
            }
        } catch (e: IOException) {
            throw Exception("Error de red al obtener los datos: ${e.message}")
        } catch (e: JsonParseException) {
            throw Exception("Error de análisis JSON al obtener los datos: ${e.message}")
        } catch (e: Exception) {
            throw Exception("Error desconocido al obtener los datos: ${e.message}")
        }
    }
}
