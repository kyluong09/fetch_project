package com.example.fetchproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fetchproject.ui.screens.home.HomeScreen

/**
 * Main Nav Host - control all navigations
 * StartDestination: Home
 */
@Composable
fun FetchNavHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home){
        composable<Screen.Home> {
            HomeScreen()
        }
    }
}