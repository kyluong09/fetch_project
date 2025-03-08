package com.example.fetchproject.navigation

import kotlinx.serialization.Serializable

/**
 * Represent different screens in the app for navigation
 */
sealed class Screen(){

    /**
     * Home
     */
    @Serializable
    data object Home : Screen()
}
