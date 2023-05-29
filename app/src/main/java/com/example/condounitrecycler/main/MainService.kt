package com.example.condounitrecycler.main

import com.example.condounitrecycler.data.models.CondoUnit
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("unities")
    suspend fun getUnities(): Response<List<CondoUnit>>
}