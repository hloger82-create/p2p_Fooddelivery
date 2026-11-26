package de.p2pfood.app.ui.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.p2pfood.app.R
import de.p2pfood.app.util.openExternal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(datasetCount: Int = -1, donateUrl: String? = null, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.about)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .windowInsetsPadding(WindowInsets.systemBars)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(stringResource(R.string.app_name), style = MaterialTheme.typography.headlineSmall)
            Text(
                "Lokale Restaurants mit eigener Lieferung oder Abholung — ohne die grossen Plattformen. " +
                    "Die App oeffnet die eigene Bestellseite des Restaurants in deinem Browser.",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(stringResource(R.string.disclaimer), style = MaterialTheme.typography.bodySmall)
            Text(stringResource(R.string.financing), style = MaterialTheme.typography.bodySmall)
            if (donateUrl != null) {
                val ctx = LocalContext.current
                OutlinedButton(
                    onClick = { ctx.openExternal(donateUrl) },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(stringResource(R.string.donate))
                }
            }
            if (datasetCount >= 0) {
                Text(
                    stringResource(R.string.about_dataset, datasetCount),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Text(
                stringResource(R.string.osm_attribution) + " — openstreetmap.org/copyright",
                style = MaterialTheme.typography.bodySmall,
            )
            Text("Version 0.1.0", style = MaterialTheme.typography.bodySmall)
        }
    }
}
