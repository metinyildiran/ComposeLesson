package com.example.composelesson.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composelesson.ui.main.MainScreen

const val mainNavigationRoute = "main_route"

fun NavGraphBuilder.mainScreen(navController: NavController) {
    composable(route = mainNavigationRoute) {
        MainScreen(navController)
    }
}