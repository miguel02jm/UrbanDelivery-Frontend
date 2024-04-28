package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pankel.proyectointeligenciaambiental.state.AppState

@Composable
fun Map(appState: AppState) {
    appState.mapaCode = "0202000105030705000200041109060110031000000200080101100110000106010701"

    val list = appState.mapaCode.chunked(2)
    appState.listaIdMapa = list.toMutableList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(appState.listaIdMapa.size) { index ->
            Box(
            ) {
                MapImages(
                    appState.listaIdMapa[index],
                    index
                )
            }
        }
    }
}