package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@Composable
fun Map(appViewModel: AppViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(appViewModel.listaIdMapa.size) { index ->
            Box(
            ) {
                if (appViewModel.listaSalidasLlegadas.isNotEmpty()){
                    MapImages(
                        appViewModel.listaIdMapa[index],
                        index,
                        appViewModel.listaSalidasLlegadas[0].salida,
                        appViewModel.listaSalidasLlegadas[0].llegada,
                        appViewModel.posRobot.value
                    )
                }else{
                    MapImages(
                        appViewModel.listaIdMapa[index],
                        index,
                        null,
                        null,
                        appViewModel.posRobot.value
                    )
                }
            }
        }
    }
}