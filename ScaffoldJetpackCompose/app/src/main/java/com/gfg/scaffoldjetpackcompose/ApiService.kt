package com.gfg.scaffoldjetpackcompose

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{id}")
    fun findOne(@Path("id") id: String): Call<SalesOrderDetail>
}