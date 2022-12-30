package com.idat.edu.pe.retrofit

import com.idat.edu.pe.model.JsonPlacehoder
import com.idat.edu.pe.model.JsonPlaceholderPhoto
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderAPI {
    @GET("todos")
    fun obtenerDatos(): Call<List<JsonPlacehoder>>

    @GET("photos")
    fun obtenerFotos(): Call<List<JsonPlaceholderPhoto>>
}