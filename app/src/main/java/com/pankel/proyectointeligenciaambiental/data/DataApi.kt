package com.pankel.proyectointeligenciaambiental.data

import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DataApi {
    @GET("InteligenciaAmbiental/recibirMapaCode")
    suspend fun getData(): Response<String>

    @POST("InteligenciaAmbiental/enviarSalidaLlegada")
    suspend fun sendData(@Body salidaLlegada: SalidaLlegada): Response<Void>
}