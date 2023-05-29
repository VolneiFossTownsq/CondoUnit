package com.example.condounitrecycler.data.details

import com.example.condounitrecycler.data.retrofit.RetrofitBuilder
import com.example.condounitrecycler.data.models.CondoUnit
import okio.IOException

class UnitDetailsRemoteDataSource {

    private val service: UnitDetailsService = getServiceInstance()

    suspend fun getUnitById(id: String): Result<CondoUnit?> {
        val response = service.getUnityById(id)
        return if (response.isSuccessful) {
                Result.success(response.body()?.firstOrNull())
        } else {
            Result.failure(IOException("An error ocurred while fetching your data"))
        }

    }

    private fun getServiceInstance(): UnitDetailsService {
        return RetrofitBuilder.getInstance().create(UnitDetailsService::class.java)
    }

}