package com.example.condounitrecycler.data.details

import com.example.condounitrecycler.data.models.CondoUnit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnitDetailsService {

    @GET("unities")
    suspend fun getUnityById(@Query("id") id: String): Response<List<CondoUnit>>

}