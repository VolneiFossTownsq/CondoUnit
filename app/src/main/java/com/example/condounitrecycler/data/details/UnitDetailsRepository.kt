package com.example.condounitrecycler.data.details

class UnitDetailsRepository(private val remoteDataSource: UnitDetailsRemoteDataSource = UnitDetailsRemoteDataSource()) {

    suspend fun getUnitById(id: String) = remoteDataSource.getUnitById(id)

}