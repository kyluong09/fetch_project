package com.example.fetchproject.data

import java.lang.Exception

/**
 * Represent network result
 */
sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Fail(val exception: Exception) : NetworkResult<Nothing>()
}