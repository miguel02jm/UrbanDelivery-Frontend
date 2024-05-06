package com.pankel.proyectointeligenciaambiental.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankel.proyectointeligenciaambiental.model.datos
import com.pankel.proyectointeligenciaambiental.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val repo: DataRepository): ViewModel() {
    private val _datos = MutableStateFlow<List<Int>>(emptyList())
    val datos = _datos.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val result = repo.getData()
                _datos.value = result ?: emptyList()
            } catch (e: Exception) {
                Log.e("TestViewModel", "Error al obtener datos: ${e.message}", e)
            }
        }
    }
}
