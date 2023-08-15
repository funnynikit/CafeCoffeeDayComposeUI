package com.sample.cafecoffeeday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.cafecoffeeday.screens.HomeScreen
import com.sample.cafecoffeeday.screens.ProductDetailScreen
import com.sample.cafecoffeeday.screens.SplashScreen

@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = SPLASH_SCREEN )
    {
        composable(SPLASH_SCREEN)
        {
            SplashScreen(navHostController = navHostController)
        }

        composable(HOME_SCREEN)
        {
            HomeScreen(navHostController = navHostController)
        }

        composable(DETAIL_SCREEN)
        {
            ProductDetailScreen(navHostController = navHostController)
        }
    }
}

const val SPLASH_SCREEN = "splash_screen"
const val HOME_SCREEN = "home_screen"
const val DETAIL_SCREEN = "detail_screen"