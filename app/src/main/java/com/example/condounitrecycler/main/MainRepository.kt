package com.example.condounitrecycler.main

class MainRepository(val mainRemoteDataSource: MainRemoteDataSource = MainRemoteDataSource()) {

    suspend fun getUnities() = mainRemoteDataSource.getUnities()

}