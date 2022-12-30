package com.idat.edu.pe.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.idat.edu.pe.model.JsonPlacehoder
import com.idat.edu.pe.model.JsonPlaceholderPhoto
import com.idat.edu.pe.retrofit.JsonplaceholderClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonPlaceholderRepository {
    val responseObtenerDatos = MutableLiveData<List<JsonPlacehoder>>()
    val responseObtenerFotos = MutableLiveData<List<JsonPlaceholderPhoto>>()

    fun obtenerDatos(): MutableLiveData<List<JsonPlacehoder>> {

        val call: Call<List<JsonPlacehoder>> =
            JsonplaceholderClient.jsonPlacehoderService.obtenerDatos()
        call.enqueue(object : Callback<List<JsonPlacehoder>> {
            override fun onResponse(
                call: Call<List<JsonPlacehoder>>,
                response: Response<List<JsonPlacehoder>>,
            ) {
                if (response.isSuccessful && response.body() != null) responseObtenerDatos.value =
                    response.body()
            }

            override fun onFailure(call: Call<List<JsonPlacehoder>>, t: Throwable) {
                Log.e("Error al obtener datos", t.message.toString())
            }

        })

        return responseObtenerDatos
    }

    fun obtenerFotos(): MutableLiveData<List<JsonPlaceholderPhoto>> {
        val call: Call<List<JsonPlaceholderPhoto>> =
            JsonplaceholderClient.jsonPlacehoderService.obtenerFotos()
        call.enqueue(object : Callback<List<JsonPlaceholderPhoto>> {
            override fun onResponse(
                call: Call<List<JsonPlaceholderPhoto>>,
                response: Response<List<JsonPlaceholderPhoto>>,
            ) {
                if (response.isSuccessful && response.body() != null) responseObtenerFotos.value =
                    response.body()
            }

            override fun onFailure(call: Call<List<JsonPlaceholderPhoto>>, t: Throwable) {
                Log.e("Error al obtener fotos", t.message.toString())
            }

        })

        return responseObtenerFotos
    }
}