package com.example.fetchproject.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * Represent a data response
 */
@Serializable
data class ItemWrapper(
    val id: Int,
    @SerializedName("listId")
    val listID: Int,
    val name: String?
) {
    // Unwrap to a cleaner version for UI use
    fun unwrap(): Item {
        return Item(id = id, listID = listID, name = name)
    }
}