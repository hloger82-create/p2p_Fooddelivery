package de.p2pfood.app.ui.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.p2pfood.app.R
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.model.VerificationStatus
import de.p2pfood.app.ui.components.label

@Composable
fun RestaurantListScreen(
    restaurants: List<Restaurant>,
    favoriteIds: Set<String>,
    onToggleFavorite: (String) -> Unit,
    onOpenDetail: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    if (restaurants.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(stringResource(R.string.empty_list))
        }
        return
    }
    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 6.dp),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(restaurants, key = { it.id }) { restaurant ->
                RestaurantCard(
                    restaurant = restaurant,
                    isFavorite = restaurant.id in favoriteIds,
                    onToggleFavorite = { onToggleFavorite(restaurant.id) },
                    onClick = { onOpenDetail(restaurant.id) },
                )
            }
        }
        ThinScrollbar(listState, Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun ThinScrollbar(listState: LazyListState, modifier: Modifier = Modifier) {
    val layoutInfo = listState.layoutInfo
    val itemCount = layoutInfo.totalItemsCount
    if (itemCount == 0) return
    val visible = layoutInfo.visibleItemsInfo
    if (visible.isEmpty()) return
    val viewport = (layoutInfo.viewportEndOffset - layoutInfo.viewportStartOffset).toDouble()
    val avgItem = visible.map { it.size }.average()
    val total = itemCount * avgItem
    if (total <= viewport) return
    val fraction = (viewport / total).toFloat().coerceIn(0.05f, 1f)
    val offset = (listState.firstVisibleItemIndex * avgItem + listState.firstVisibleItemScrollOffset).toFloat()
    val thumbTop = (offset / total.toFloat()).coerceIn(0f, 1f - fraction)
    val thumbColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.55f)
    Canvas(modifier = modifier.fillMaxHeight().width(3.dp)) {
        val thumbHeight = size.height * fraction
        drawRect(
            color = thumbColor,
            topLeft = Offset(0f, size.height * thumbTop),
            size = Size(size.width, thumbHeight),
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onClick: () -> Unit,
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp,
            pressedElevation = 6.dp,
        ),
    ) {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    restaurant.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f),
                )
                IconButton(onClick = onToggleFavorite, modifier = Modifier.size(32.dp)) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Star else Icons.Default.StarBorder,
                        contentDescription = stringResource(R.string.favorites),
                        tint = if (isFavorite) Color(0xFFFFC107) else MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
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
                        modifier = Modifier.height(26.dp),
                        label = { Text(cuisine.label(), style = MaterialTheme.typography.labelSmall) },
                    )
                }
                restaurant.orderTypes.forEach { orderType ->
                    AssistChip(
                        onClick = {},
                        modifier = Modifier.height(26.dp),
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
