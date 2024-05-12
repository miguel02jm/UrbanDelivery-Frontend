package com.pankel.proyectointeligenciaambiental.di

import com.pankel.proyectointeligenciaambiental.data.DataApi
import com.pankel.proyectointeligenciaambiental.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesDataApi(retrofit: Retrofit): DataApi {
        return retrofit.create(DataApi::class.java)
    }
}
