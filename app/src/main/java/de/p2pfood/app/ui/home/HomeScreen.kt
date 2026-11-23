package de.p2pfood.app.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.p2pfood.app.R
import de.p2pfood.app.ui.list.RestaurantListScreen
import de.p2pfood.app.ui.map.MapScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenDetail: (String) -> Unit,
    onOpenAbout: () -> Unit,
    onToggleTheme: () -> Unit,
    viewModel: HomeViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.region?.name ?: stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(Icons.Default.DarkMode, contentDescription = stringResource(R.string.toggle_theme))
                    }
                    IconButton(onClick = onOpenAbout) {
                        Icon(Icons.Default.Info, contentDescription = stringResource(R.string.about))
                    }
                },
            )
        },
    ) { padding ->
        Column(Modifier.padding(padding)) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 2.dp,
                shadowElevation = 2.dp,
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        OutlinedTextField(
                            value = state.filters.query,
                            onValueChange = viewModel::setQuery,
                            modifier = Modifier.weight(1f).height(48.dp),
                            singleLine = true,
                            placeholder = { Text(stringResource(R.string.search_hint)) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        )
                        OutlinedTextField(
                            value = state.filters.postcode,
                            onValueChange = viewModel::setPostcode,
                            modifier = Modifier.width(96.dp).height(48.dp),
                            singleLine = true,
                            placeholder = { Text(stringResource(R.string.postcode_hint)) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )
                        IconButton(
                            onClick = viewModel::toggleFavoritesOnly,
                            modifier = Modifier.size(40.dp),
                        ) {
                            Icon(
                                imageVector = if (state.filters.favoritesOnly) Icons.Default.Star else Icons.Default.StarBorder,
                                contentDescription = stringResource(R.string.favorites),
                                tint = if (state.filters.favoritesOnly) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                            )
                        }
                    }
                    FilterBar(
                        cuisines = state.restaurants.flatMap { it.cuisines }.distinct().sorted(),
                        selectedCuisines = state.filters.cuisines,
                        onToggleCuisine = viewModel::toggleCuisine,
                        selectedOrderTypes = state.filters.orderTypes,
                        onToggleOrderType = viewModel::toggleOrderType,
                        deliversOnly = state.filters.deliversOnly,
                        onDeliversOnly = viewModel::setDeliversOnly,
                    )
                }
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
            Box(Modifier.weight(1f).fillMaxWidth()) {
                when (selectedTab) {
                    0 -> RestaurantListScreen(
                        restaurants = state.filtered,
                        favoriteIds = state.favoriteIds,
                        onToggleFavorite = viewModel::toggleFavorite,
                        onOpenDetail = onOpenDetail,
                    )
                    1 -> state.region?.let { region ->
                        MapScreen(region, state.filtered, onOpenDetail)
                    }
                }
            }
        }
    }
}
