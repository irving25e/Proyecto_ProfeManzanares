package com.gfg.scaffoldjetpackcompose

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Cliente {
    private const val BASE_URL = "http://169.254.13.50:3000/api/v1/Sales.SalesOrderDetail/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}