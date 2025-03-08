package com.example.fetchproject.dependencyInjection.koinModule

import com.example.fetchproject.data.RetrofitClient
import com.example.fetchproject.ui.screens.home.HomeRepository
import com.example.fetchproject.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module for providing repository
 */
private val repositoryModule = module {
    single { HomeRepository(get()) }
}

/**
 * Koin module for providing viewmodel
 */
private val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

/**
 * Koin module for providing client
 */
private val clientModule = module {
    single { RetrofitClient.dataClient }
}

/**
 * List of modules
 */
val koinModule = listOf(
    clientModule,
    viewModelModule,
    repositoryModule
)