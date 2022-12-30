package com.idat.edu.pe.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object JsonplaceholderClient {
    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jsonPlacehoderService: JsonPlaceholderAPI by lazy {
        getRetrofit().create(JsonPlaceholderAPI::class.java)
    }
}