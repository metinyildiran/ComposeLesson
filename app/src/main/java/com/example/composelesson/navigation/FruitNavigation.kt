package com.example.composelesson.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.composelesson.ui.fruit.FruitScreen

const val fruitNavigationRoute = "fruit_route"

fun NavController.navigateToFruit() {
    this.navigate(fruitNavigationRoute)
}

fun NavGraphBuilder.fruitScreen() {
    composable(route = fruitNavigationRoute) {
        FruitScreen()
    }
}