package com.example.condounitrecycler.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val baseUrl = "https://6450f83ea32219691156c64e.mockapi.io/api/v1/"

    fun getInstance(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}