package de.p2pfood.app.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import de.p2pfood.app.R
import de.p2pfood.app.ui.list.RestaurantListScreen
import de.p2pfood.app.ui.map.MapScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenDetail: (String) -> Unit,
    onOpenAbout: () -> Unit,
    viewModel: HomeViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.region?.name ?: stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = onOpenAbout) {
                        Icon(Icons.Default.Info, contentDescription = stringResource(R.string.about))
                    }
                },
            )
        },
    ) { padding ->
        Column(Modifier.padding(padding).windowInsetsPadding(WindowInsets.systemBars)) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 2.dp,
                shadowElevation = 2.dp,
            ) {
                FilterBar(
                    cuisines = state.restaurants.flatMap { it.cuisines }.distinct().sorted(),
                    selectedCuisines = state.selectedCuisines,
                    onToggleCuisine = viewModel::toggleCuisine,
                    selectedOrderTypes = state.selectedOrderTypes,
                    onToggleOrderType = viewModel::toggleOrderType,
                    deliversOnly = state.deliversOnly,
                    onDeliversOnly = viewModel::setDeliversOnly,
                )
            }
            HorizontalDivider(thickness = 1.dp)
            TabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text(stringResource(R.string.tab_list)) },
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text(stringResource(R.string.tab_map)) },
                )
            }
            when (selectedTab) {
                0 -> RestaurantListScreen(state.filtered, onOpenDetail)
                1 -> state.region?.let { region ->
                    MapScreen(region, state.filtered, onOpenDetail)
                }
            }
        }
    }
}
