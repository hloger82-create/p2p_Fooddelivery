package de.p2pfood.app.ui.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
    Column(Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
        Text(
            stringResource(R.string.filter_cuisine),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            cuisines.forEach { cuisine ->
                FilterChip(
                    modifier = Modifier.height(28.dp),
                    selected = cuisine in selectedCuisines,
                    onClick = { onToggleCuisine(cuisine) },
                    label = { Text(cuisine.label(), style = MaterialTheme.typography.labelSmall) },
                )
            }
        }
        Text(
            stringResource(R.string.filter_order),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 2.dp),
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
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
        }
    }
}
