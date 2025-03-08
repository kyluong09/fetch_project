package com.example.fetchproject.data.client

import com.example.fetchproject.data.model.ItemWrapper
import retrofit2.http.GET

/**
 * Represent Data API client
 */
interface DataClient {
    @GET("hiring.json")
    suspend fun getItems() : List<ItemWrapper>
}