package com.idat.edu.pe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.idat.edu.pe.model.JsonPlacehoder
import com.idat.edu.pe.model.JsonPlaceholderPhoto
import com.idat.edu.pe.repository.JsonPlaceholderRepository

class JsonPlaceHolderViewModel : ViewModel() {
    var responseObtenerDatos: LiveData<List<JsonPlacehoder>>
    var responseObtenerFotos: LiveData<List<JsonPlaceholderPhoto>>

    private var repository = JsonPlaceholderRepository()

    init {
        responseObtenerDatos = repository.responseObtenerDatos
        responseObtenerFotos = repository.responseObtenerFotos
    }

    fun obtenerDatos() {
        responseObtenerDatos = repository.obtenerDatos()
    }

    fun obtenerFotos() {
        responseObtenerFotos = repository.obtenerFotos()
    }
}