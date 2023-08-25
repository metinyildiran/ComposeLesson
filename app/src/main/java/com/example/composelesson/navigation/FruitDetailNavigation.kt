package com.example.composelesson.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composelesson.ui.fruitDetail.FruitDetailScreen

const val fruitDetailNavigationRoute = "fruit_detail_navigation"
const val fruitIdArg = "fruitIdArg"

fun NavController.navigateToFruitDetail(fruitId: String) {
    this.navigate("$fruitDetailNavigationRoute/$fruitId")
}

fun NavGraphBuilder.fruitDetailScreen() {
    composable(route = "$fruitDetailNavigationRoute/{$fruitIdArg}", arguments = listOf(
        navArgument(fruitIdArg) {
            type = NavType.StringType
        }
    )) {
        FruitDetailScreen()
    }
}