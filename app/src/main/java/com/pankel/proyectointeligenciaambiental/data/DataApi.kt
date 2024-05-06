package com.pankel.proyectointeligenciaambiental.data

import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import com.pankel.proyectointeligenciaambiental.model.datos
import com.pankel.proyectointeligenciaambiental.util.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DataApi {
    @GET("InteligenciaAmbiental/datos")
    suspend fun getData(): Response<List<Int>>

    @POST("InteligenciaAmbiental/enviarSalidaLlegada")
    suspend fun sendData(@Body salidaLlegada: SalidaLlegada): Response<Void>
}