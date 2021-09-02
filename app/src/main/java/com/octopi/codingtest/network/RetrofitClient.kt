package com.octopi.codingtest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private var baseUrl = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object{
        var retrofitClient: RetrofitClient? = null
        @Synchronized
        fun getInstance(): RetrofitClient? {
            if (retrofitClient == null)
                retrofitClient = RetrofitClient()
            return retrofitClient
        }
    }



    fun getApi(): ApiInterface? {
        return retrofit?.create(ApiInterface::class.java)
    }
}