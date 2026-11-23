package de.p2pfood.app.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.p2pfood.app.R
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.model.VerificationStatus
import de.p2pfood.app.ui.components.label

@Composable
fun RestaurantListScreen(
    restaurants: List<Restaurant>,
    onOpenDetail: (String) -> Unit,
) {
    if (restaurants.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(stringResource(R.string.empty_list))
        }
        return
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(restaurants, key = { it.id }) { restaurant ->
            RestaurantCard(restaurant) { onOpenDetail(restaurant.id) }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    ElevatedCard(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(14.dp)) {
            Text(restaurant.name, style = MaterialTheme.typography.titleMedium)
            val cityLine = listOfNotNull(restaurant.address.postcode, restaurant.address.city)
                .joinToString(" ")
            val addressLine = listOfNotNull(restaurant.address.street, cityLine.takeIf { it.isNotBlank() })
                .joinToString(", ")
            if (addressLine.isNotBlank()) {
                Text(
                    addressLine,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(top = 6.dp),
            ) {
                restaurant.cuisines.forEach { cuisine ->
                    AssistChip(
                        onClick = {},
                        label = { Text(cuisine.label(), style = MaterialTheme.typography.labelSmall) },
                    )
                }
                restaurant.orderTypes.forEach { orderType ->
                    AssistChip(
                        onClick = {},
                        label = { Text(orderType.label(), style = MaterialTheme.typography.labelSmall) },
                    )
                }
            }
            Row(
                modifier = Modifier.padding(top = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                if (restaurant.delivers) Badge { Text(stringResource(R.string.delivers)) }
                if (restaurant.pickup) Badge { Text(stringResource(R.string.pickup)) }
                if (restaurant.status != VerificationStatus.VERIFIED) {
                    Badge(containerColor = MaterialTheme.colorScheme.tertiaryContainer) {
                        Text(stringResource(R.string.verification_open))
                    }
                }
            }
        }
    }
}
