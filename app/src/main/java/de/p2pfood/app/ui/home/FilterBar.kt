package de.p2pfood.app.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
) {
    Column(Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
        Text(stringResource(R.string.filter_cuisine), style = MaterialTheme.typography.labelMedium)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            cuisines.forEach { cuisine ->
                FilterChip(
                    selected = cuisine in selectedCuisines,
                    onClick = { onToggleCuisine(cuisine) },
                    label = { Text(cuisine.label()) },
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Text(stringResource(R.string.filter_order), style = MaterialTheme.typography.labelMedium)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OrderType.entries.forEach { orderType ->
                FilterChip(
                    selected = orderType in selectedOrderTypes,
                    onClick = { onToggleOrderType(orderType) },
                    label = { Text(orderType.label()) },
                )
            }
            FilterChip(
                selected = deliversOnly,
                onClick = { onDeliversOnly(!deliversOnly) },
                label = { Text(stringResource(R.string.filter_delivers)) },
            )
        }
    }
}
