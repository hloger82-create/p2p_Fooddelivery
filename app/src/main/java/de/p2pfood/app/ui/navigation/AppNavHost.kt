package de.p2pfood.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import de.p2pfood.app.data.AppContainer
import de.p2pfood.app.ui.about.AboutScreen
import de.p2pfood.app.ui.detail.RestaurantDetailScreen
import de.p2pfood.app.ui.detail.detailViewModel
import de.p2pfood.app.ui.home.HomeScreen
import de.p2pfood.app.ui.home.homeViewModelFactory

@Composable
fun AppNavHost(container: AppContainer) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onOpenDetail = { id -> navController.navigate("detail/$id") },
                onOpenAbout = { navController.navigate("about") },
                viewModel = viewModel(factory = homeViewModelFactory(container)),
            )
        }
        composable(
            route = "detail/{restaurantId}",
            arguments = listOf(navArgument("restaurantId") { type = NavType.StringType }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("restaurantId").orEmpty()
            RestaurantDetailScreen(
                viewModel = viewModel(
                    factory = androidx.lifecycle.viewmodel.viewModelFactory {
                        androidx.lifecycle.viewmodel.initializer { detailViewModel(container, id) }
                    },
                ),
                onBack = { navController.popBackStack() },
            )
        }
        composable("about") {
            AboutScreen(onBack = { navController.popBackStack() })
        }
    }
}
