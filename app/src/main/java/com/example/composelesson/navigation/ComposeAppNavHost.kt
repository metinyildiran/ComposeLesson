package com.example.composelesson.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun BookAppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = mainNavigationRoute,
    ) {
        fruitScreen()
        mainScreen(navController)
    }
}