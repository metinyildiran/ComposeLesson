package com.example.composelesson.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun ComposeAppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = mainNavigationRoute,
    ) {
        fruitScreen(navController)
        mainScreen(navController)
        fruitDetailScreen()
    }
}