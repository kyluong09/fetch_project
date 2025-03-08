package com.example.fetchproject.ui.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchproject.data.NetworkResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Home ViewModel
 */
class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    private val TAG = this::class.java.name
    val uiState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState.Loading)
    val isRefreshing = mutableStateOf(false)

    // Refresh HomeScreen
    fun refreshItems() {
        viewModelScope.launch {
            isRefreshing.value = true
            // Keep pullRefresh indicator for 500m
            delay(500)
            isRefreshing.value = false
            uiState.value = HomeScreenUIState.Loading
            getItems()
        }
    }

    /**
     * Fetch items from HomeRepository
     */
    fun getItems() {
        viewModelScope.launch {
            try {
                when (val response = homeRepository.getItems()) {
                    is NetworkResult.Success -> {
                        val items = response.data
                        // Remove null and blank name
                        // Sort result first by "listID" then "name"
                        // Group by listID
                        val updateItems = items.filter { !it.name.isNullOrBlank() }
                            .sortedWith(
                                compareBy(
                                    { it.listID },
                                    { extractNumberFromName(it.name) })
                            )
                            .groupBy { it.listID }

                        when {
                            updateItems.isEmpty() -> {
                                throw Exception("Data is empty")
                            }

                            else -> {
                                uiState.value = HomeScreenUIState.Loaded(updateItems)
                            }
                        }
                    }

                    is NetworkResult.Fail -> {
                        val e = response.exception
                        throw e
                    }

                }
            } catch (e: Exception) {
                Log.e(TAG, "Unable to get items", e)
                uiState.value = HomeScreenUIState.Error(e)
            }
        }
    }

    /**
     * Extracts the number from a name like "Item 42".
     * If no number is found, returns Int.MAX_VALUE to push it the end of sorting.
     */
    private fun extractNumberFromName(name: String?): Int {
        if (name.isNullOrBlank()) return Int.MAX_VALUE
        val lists = name.split(" ")
        val number = lists.getOrNull(1)?.toIntOrNull()
        return number ?: Int.MAX_VALUE
    }
}