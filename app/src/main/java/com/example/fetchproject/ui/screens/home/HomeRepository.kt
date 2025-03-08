package com.example.fetchproject.ui.screens.home

import com.example.fetchproject.data.NetworkResult
import com.example.fetchproject.data.client.DataClient
import com.example.fetchproject.data.model.Item

/**
 * Repository layer - responsible for fetching and processing data
 */
class HomeRepository(val dataClient: DataClient) {

    /**
     * Fetch items and map it to a clean UI friendly format
     */
    suspend fun getItems(): NetworkResult<List<Item>> {
        return try {
            val data = dataClient.getItems().map { it.unwrap() }
            NetworkResult.Success(data)
        } catch (e: Exception) {
            NetworkResult.Fail(e)
        }
    }
}