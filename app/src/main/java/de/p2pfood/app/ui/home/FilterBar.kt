package de.p2pfood.app.ui.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.p2pfood.app.R
import de.p2pfood.app.data.model.Cuisine
import de.p2pfood.app.data.model.OrderType
import de.p2pfood.app.ui.components.label

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterBar(
    cuisines: List<Cuisine>,
    selectedCuisines: Set<Cuisine>,
    onToggleCuisine: (Cuisine) -> Unit,
    selectedOrderTypes: Set<OrderType>,
    onToggleOrderType: (OrderType) -> Unit,
    deliversOnly: Boolean,
    onDeliversOnly: (Boolean) -> Unit,
    openNow: Boolean,
    onToggleOpenNow: () -> Unit,
) {
    var cuisineExpanded by remember { mutableStateOf(false) }
    var orderExpanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
        FilterSection(
            title = stringResource(R.string.filter_cuisine),
            expanded = cuisineExpanded,
            onToggleExpanded = { cuisineExpanded = !cuisineExpanded },
        ) {
            ChipRow(expanded = cuisineExpanded) {
                cuisines.forEach { cuisine ->
                    FilterChip(
                        modifier = Modifier.height(28.dp),
                        selected = cuisine in selectedCuisines,
                        onClick = { onToggleCuisine(cuisine) },
                        label = { Text(cuisine.label(), style = MaterialTheme.typography.labelSmall) },
                    )
                }
            }
        }
        FilterSection(
            title = stringResource(R.string.filter_order),
            expanded = orderExpanded,
            onToggleExpanded = { orderExpanded = !orderExpanded },
        ) {
            ChipRow(expanded = orderExpanded) {
                OrderType.entries.forEach { orderType ->
                    FilterChip(
                        modifier = Modifier.height(28.dp),
                        selected = orderType in selectedOrderTypes,
                        onClick = { onToggleOrderType(orderType) },
                        label = { Text(orderType.label(), style = MaterialTheme.typography.labelSmall) },
                    )
                }
                FilterChip(
                    modifier = Modifier.height(28.dp),
                    selected = deliversOnly,
                    onClick = { onDeliversOnly(!deliversOnly) },
                    label = { Text(stringResource(R.string.filter_delivers), style = MaterialTheme.typography.labelSmall) },
                )
                FilterChip(
                    modifier = Modifier.height(28.dp),
                    selected = openNow,
                    onClick = onToggleOpenNow,
                    label = { Text(stringResource(R.string.open_now), style = MaterialTheme.typography.labelSmall) },
                )
            }
        }
    }
}

@Composable
private fun FilterSection(
    title: String,
    expanded: Boolean,
    onToggleExpanded: () -> Unit,
    content: @Composable () -> Unit,
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f),
            )
            IconButton(onClick = onToggleExpanded, modifier = Modifier.size(24.dp)) {
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = if (expanded) "einklappen" else "ausklappen",
                    modifier = Modifier.size(18.dp),
                )
            }
        }
        content()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ChipRow(expanded: Boolean, content: @Composable () -> Unit) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .then(if (expanded) Modifier else Modifier.horizontalScroll(rememberScrollState()))
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        content()
    }
}
