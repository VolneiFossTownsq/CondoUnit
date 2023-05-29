package com.example.condounitrecycler.main

import com.example.condounitrecycler.data.retrofit.RetrofitBuilder
import com.example.condounitrecycler.data.models.CondoUnit

class MainRemoteDataSource {

    private val mainService: MainService = getServiceInstance()

    suspend fun getUnities(): Result<List<CondoUnit>> {
        val response = mainService.getUnities() // <-- Corrected variable name
        return if (response.isSuccessful) {
            Result.success(response.body().orEmpty())
        } else {
            Result.failure(java.io.IOException("An error ocurred while fetching your data"))
        }
    }

    private fun getServiceInstance(): MainService {
        return RetrofitBuilder.getInstance().create(MainService::class.java)
    }
}