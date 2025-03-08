package com.example.fetchproject.data

import com.example.fetchproject.data.client.DataClient
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com"

    private fun buildRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }


    val dataClient: DataClient
        get() = buildRetrofit()
            .build()
            .create(DataClient::class.java)
}