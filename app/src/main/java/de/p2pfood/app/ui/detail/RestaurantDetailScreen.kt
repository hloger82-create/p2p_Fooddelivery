package de.p2pfood.app.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.p2pfood.app.R
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.ui.components.label
import de.p2pfood.app.util.callNumber
import de.p2pfood.app.util.openExternal

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RestaurantDetailScreen(
    viewModel: DetailViewModel,
    onBack: () -> Unit,
) {
    val restaurant by viewModel.restaurant.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(restaurant?.name ?: "") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                },
                actions = {
                    val isFavorite by viewModel.isFavorite.collectAsState()
                    IconButton(onClick = { viewModel.toggleFavorite() }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = stringResource(R.string.favorites),
                            tint = if (isFavorite) Color(0xFFFFC107) else MaterialTheme.colorScheme.onSurface,
                        )
                    }
                },
            )
        },
    ) { padding ->
        val r = restaurant
        if (r == null) {
            Text(
                stringResource(R.string.restaurant_not_found),
                modifier = Modifier.padding(padding).padding(16.dp),
            )
            return@Scaffold
        }
        Column(
            modifier = Modifier
                .padding(padding)
                .windowInsetsPadding(WindowInsets.systemBars)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    DetailBody(r)
                }
            }

            val target = r.orderUrl ?: r.website
            if (target != null) {
                Button(
                    onClick = { context.openExternal(target) },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Icon(Icons.Default.OpenInBrowser, contentDescription = null)
                    Spacer(Modifier.padding(4.dp))
                    Text(stringResource(R.string.action_to_restaurant))
                }
            }
            if (r.phone != null) {
                OutlinedButton(
                    onClick = { context.callNumber(r.phone!!) },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Icon(Icons.Default.Call, contentDescription = null)
                    Spacer(Modifier.padding(4.dp))
                    Text(stringResource(R.string.action_call))
                }
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 1.dp,
                shape = MaterialTheme.shapes.small,
            ) {
                Text(
                    stringResource(R.string.disclaimer),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(10.dp),
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DetailBody(r: Restaurant) {
    val cityLine = listOfNotNull(r.address.postcode, r.address.city).joinToString(" ")
    val addressLine = listOfNotNull(r.address.street, cityLine.takeIf { it.isNotBlank() }).joinToString(", ")
    if (addressLine.isNotBlank()) {
        Text(addressLine, style = MaterialTheme.typography.bodyLarge)
    }
    FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        r.cuisines.forEach { AssistChip(onClick = {}, label = { Text(it.label()) }) }
        r.orderTypes.forEach { AssistChip(onClick = {}, label = { Text(it.label()) }) }
    }
    r.openingHours?.let {
        DetailRow(stringResource(R.string.opening_hours), it)
    }
    if (r.delivers && r.deliveryAreas.isNotEmpty()) {
        DetailRow(stringResource(R.string.delivery_areas), r.deliveryAreas.joinToString(", "))
    }
    r.minOrderValue?.let {
        DetailRow(stringResource(R.string.min_order), "%.2f €".format(it))
    }
    r.deliveryFee?.let {
        DetailRow(stringResource(R.string.delivery_fee), "%.2f €".format(it))
    }
    r.phone?.let {
        DetailRow(stringResource(R.string.phone_label), it)
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Column {
        Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
        Text(value, style = MaterialTheme.typography.bodyMedium)
    }
}
