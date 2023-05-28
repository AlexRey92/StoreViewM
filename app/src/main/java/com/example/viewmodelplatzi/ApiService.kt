package com.example.viewmodelplatzi

import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET(value = "products")
    suspend fun getProducts(): Response<MutableList<ProductResponse>>
}

var retrofit= Retrofit.Builder()
    .baseUrl("https://api.escuelajs.co/api/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service:ApiService= retrofit.create(ApiService::class.java)