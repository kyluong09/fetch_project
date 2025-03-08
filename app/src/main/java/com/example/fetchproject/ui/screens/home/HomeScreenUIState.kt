package com.example.fetchproject.ui.screens.home

import com.example.fetchproject.data.model.Item

/**
 * Represent Home screen's UI state
 */
sealed class HomeScreenUIState {
    data object Loading : HomeScreenUIState()
    data class Loaded(val items: Map<Int, List<Item>>) : HomeScreenUIState()
    data class Error(val e: Exception) : HomeScreenUIState()
}