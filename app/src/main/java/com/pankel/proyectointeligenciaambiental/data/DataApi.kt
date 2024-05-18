package com.pankel.proyectointeligenciaambiental.data

import com.pankel.proyectointeligenciaambiental.model.MapaCode
import com.pankel.proyectointeligenciaambiental.model.PosRobot
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DataApi {
    @GET("recibirMapaCode")
    suspend fun getMapaCode(): Response<MapaCode>

    @GET("recibirPosicionRobot")
    suspend fun getPosRobot(): Response<PosRobot>

    @POST("enviarSalidaLlegada")
    suspend fun sendData(@Body salidaLlegada: SalidaLlegada): Response<Void>
}