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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.window.Dialog
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
    var showHelp by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.region?.name ?: stringResource(R.string.app_name)) },
                actions = {
                    if (viewModel.regionIds.size > 1) {
                        var regionMenuExpanded by remember { mutableStateOf(false) }
                        Box {
                            TextButton(onClick = { regionMenuExpanded = true }) {
                                Text(state.region?.name ?: viewModel.regionIds.first())
                                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                            }
                            DropdownMenu(
                                expanded = regionMenuExpanded,
                                onDismissRequest = { regionMenuExpanded = false },
                            ) {
                                viewModel.regionIds.forEach { id ->
                                    DropdownMenuItem(
                                        text = { Text(viewModel.regionNames[id] ?: id) },
                                        onClick = {
                                            viewModel.selectRegion(id)
                                            regionMenuExpanded = false
                                        },
                                    )
                                }
                            }
                        }
                    }
                    IconButton(onClick = { showHelp = true }) {
                        Icon(Icons.Default.HelpOutline, contentDescription = stringResource(R.string.help))
                    }
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
                tonalElevation = 3.dp,
                shadowElevation = 4.dp,
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        OutlinedTextField(
                            value = state.filters.query,
                            onValueChange = viewModel::setQuery,
                            modifier = Modifier.weight(1f).height(52.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium,
                            label = { Text(stringResource(R.string.search_hint), style = MaterialTheme.typography.bodySmall) },
                            placeholder = { Text(stringResource(R.string.search_hint), style = MaterialTheme.typography.bodySmall) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(20.dp)) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            ),
                        )
                        OutlinedTextField(
                            value = state.filters.postcode,
                            onValueChange = viewModel::setPostcode,
                            modifier = Modifier.width(110.dp).height(52.dp),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.bodyMedium,
                            label = { Text(stringResource(R.string.postcode_hint), style = MaterialTheme.typography.bodySmall) },
                            placeholder = { Text(stringResource(R.string.postcode_example), style = MaterialTheme.typography.bodySmall) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            ),
                        )
                        IconButton(
                            onClick = viewModel::toggleFavoritesOnly,
                            modifier = Modifier.size(36.dp),
                        ) {
                            Icon(
                                imageVector = if (state.filters.favoritesOnly) Icons.Default.Star else Icons.Default.StarBorder,
                                contentDescription = stringResource(R.string.favorites),
                                modifier = Modifier.size(20.dp),
                                tint = if (state.filters.favoritesOnly) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                            )
                        }
                    }
                    val plz = state.filters.postcode.trim()
                    val regionCfg = state.region
                    if (plz.length == 5 && regionCfg?.postcodes?.isNotEmpty() == true && plz !in regionCfg.postcodes) {
                        Text(
                            text = stringResource(R.string.plz_outside_region, regionCfg.name),
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp),
                        )
                    }
                    FilterBar(
                        cuisines = state.restaurants.flatMap { it.cuisines }.distinct().sorted(),
                        selectedCuisines = state.filters.cuisines,
                        onToggleCuisine = viewModel::toggleCuisine,
                        selectedOrderTypes = state.filters.orderTypes,
                        onToggleOrderType = viewModel::toggleOrderType,
                        deliversOnly = state.filters.deliversOnly,
                        onDeliversOnly = viewModel::setDeliversOnly,
                        openNow = state.filters.openNow,
                        onToggleOpenNow = viewModel::toggleOpenNow,
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
    if (showHelp) {
        Dialog(onDismissRequest = { showHelp = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
                tonalElevation = 6.dp,
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        stringResource(R.string.help_title),
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        stringResource(R.string.help_body),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 8.dp),
                    )
                    Button(
                        onClick = { showHelp = false },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 12.dp),
                    ) {
                        Text(stringResource(R.string.understood))
                    }
                }
            }
        }
    }
}
