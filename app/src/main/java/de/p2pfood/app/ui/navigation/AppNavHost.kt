package de.p2pfood.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
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
fun AppNavHost(container: AppContainer, onToggleTheme: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onOpenDetail = { id -> navController.navigate("detail/$id") },
                onOpenAbout = { navController.navigate("about") },
                onToggleTheme = onToggleTheme,
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
                    factory = viewModelFactory {
                        initializer { detailViewModel(container, id) }
                    },
                ),
                onBack = { navController.popBackStack() },
            )
        }
        composable("about") {
            val regionId = container.regionCatalog.availableRegionIds().first()
            val datasetCount by container.restaurantRepository.observeCount(regionId).collectAsState(initial = -1)
            AboutScreen(datasetCount = datasetCount, onBack = { navController.popBackStack() })
        }
    }
}
