package de.p2pfood.app.ui.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import de.p2pfood.app.R
import de.p2pfood.app.data.model.RegionConfig
import de.p2pfood.app.data.model.Restaurant
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun MapScreen(
    region: RegionConfig,
    restaurants: List<Restaurant>,
    onSelect: (String) -> Unit,
) {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            controller.setZoom(region.zoom)
            controller.setCenter(GeoPoint(region.centerLat, region.centerLon))
        }
    }

    DisposableEffect(Unit) {
        mapView.onResume()
        onDispose { mapView.onPause() }
    }

    Box(Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { mapView },
            update = { mv ->
                mv.overlays.removeAll(mv.overlays.filterIsInstance<Marker>())
                restaurants
                    .filter { it.lat != null && it.lon != null }
                    .forEach { r ->
                        val marker = Marker(mv).apply {
                            position = GeoPoint(r.lat!!, r.lon!!)
                            title = r.name
                            setOnMarkerClickListener { _, _ ->
                                onSelect(r.id)
                                true
                            }
                        }
                        mv.overlays.add(marker)
                    }
                mv.invalidate()
            },
        )
        Text(
            text = stringResource(R.string.osm_attribution),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(6.dp)
                .background(
                    MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
                    RoundedCornerShape(4.dp),
                )
                .padding(4.dp),
        )
    }
}
