package com.example.fetchproject.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel

/**
 * Represent UI - Home Screen
 */
@Composable
fun HomeScreen() {
    // Injections
    val homeViewModel: HomeViewModel = getViewModel()

    // UI State
    val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()

    // Content
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        when (uiState.value) {
            HomeScreenUIState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is HomeScreenUIState.Loaded -> {
                val data = (uiState.value as HomeScreenUIState.Loaded).items
                HomeScreenLoaded(
                    itemsMap = data,
                    isRefreshing = homeViewModel.isRefreshing.value,
                    onRefresh = { homeViewModel.refreshItems() })
            }

            is HomeScreenUIState.Error -> {
                ErrorView(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    LaunchedEffect(Unit) {
        homeViewModel.getItems()
    }
}