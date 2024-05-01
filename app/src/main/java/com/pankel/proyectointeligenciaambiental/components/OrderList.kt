package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pankel.proyectointeligenciaambiental.model.SalidaLlegada
import com.pankel.proyectointeligenciaambiental.ui.theme.background2
import com.pankel.proyectointeligenciaambiental.ui.theme.background3
import com.pankel.proyectointeligenciaambiental.viewModel.AppViewModel

@Composable
fun OrderList(appViewModel: AppViewModel) {
   if(appViewModel.listaSalidasLlegadas.isNotEmpty()){
      LazyColumn(modifier = Modifier.padding(10.dp)) {
         itemsIndexed(appViewModel.listaSalidasLlegadas) { index, item ->
            SalidaLlegadaItem(item, isFirstItem = index == 0)
         }
      }
   } else {
      Text(text = "Actualmente no existen pedidos activos", color = Color.Gray)
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalidaLlegadaItem(salidaLlegada: SalidaLlegada, isFirstItem: Boolean) {
   OutlinedCard(
      colors = CardDefaults.cardColors(
         containerColor = if (isFirstItem) background3 else background2,
         contentColor = Color.White
      ),
      border = BorderStroke(2.dp, Color.Black),
      modifier = Modifier.padding(5.dp)
   ) {
      Text(
         text = "Entrada: ${salidaLlegada.salida} - Llegada: ${salidaLlegada.llegada}",
         modifier = Modifier
            .padding(10.dp),
         textAlign = TextAlign.Center,
         fontSize = 24.sp,
      )
   }
}