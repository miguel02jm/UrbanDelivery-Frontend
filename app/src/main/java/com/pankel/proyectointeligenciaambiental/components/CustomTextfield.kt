package com.pankel.proyectointeligenciaambiental.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun customTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.padding(10.dp),
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        maxLines = 1,
    )
}