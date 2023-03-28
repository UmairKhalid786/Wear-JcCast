package com.techlads.wearjccast.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.techlads.wearjccast.presentation.home.HomeScreen
import com.techlads.wearjccast.presentation.withToken.DeviceTokenAuthenticationScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    SwipeDismissableNavHost(navController = navController, startDestination = Screens.LoginToken.title) {
        // e.g will add auth routes here if when we will extend project

        composable(
            Screens.LoginToken.title) {
            DeviceTokenAuthenticationScreen {
                navController.navigate(it.title)
            }
        }

        composable(
            Screens.Home.title) {
            HomeScreen()
        }
    }
}
