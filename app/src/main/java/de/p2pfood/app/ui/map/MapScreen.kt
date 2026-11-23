package de.p2pfood.app.ui.map

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import de.p2pfood.app.R
import de.p2pfood.app.data.model.Cuisine
import de.p2pfood.app.data.model.RegionConfig
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.ui.components.color
import de.p2pfood.app.ui.components.label
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MapScreen(
    region: RegionConfig,
    restaurants: List<Restaurant>,
    onSelect: (String) -> Unit,
) {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            clipToOutline = true
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            controller.setZoom(region.zoom)
            controller.setCenter(GeoPoint(region.centerLat, region.centerLon))
            region.bbox?.let { (south, west, north, east) ->
                setScrollableAreaLimitLatitude(north, south, 100000)
                setScrollableAreaLimitLongitude(west, east, 100000)
            }
        }
    }
    val markerIcons = remember { mutableMapOf<Cuisine, Drawable>() }

    DisposableEffect(Unit) {
        mapView.onResume()
        onDispose { mapView.onPause() }
    }

    val withCoords = restaurants.filter { it.lat != null && it.lon != null }

    Box(Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { mapView },
            update = { mv ->
                mv.overlays.removeAll(mv.overlays.filterIsInstance<Marker>())
                withCoords.forEach { r ->
                    val cuisine = r.cuisines.firstOrNull() ?: Cuisine.OTHER
                    val icon = markerIcons.getOrPut(cuisine) { markerIcon(context, cuisine.color()) }
                    val marker = Marker(mv).apply {
                        position = GeoPoint(r.lat!!, r.lon!!)
                        title = r.name
                        setIcon(icon)
                        setAnchor(0.5f, 0.5f)
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
        val legendCuisines = withCoords.flatMap { it.cuisines }.distinct().sorted()
        if (legendCuisines.isNotEmpty()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp),
                tonalElevation = 2.dp,
                shadowElevation = 2.dp,
                shape = RoundedCornerShape(8.dp),
            ) {
                FlowRow(
                    modifier = Modifier
                        .padding(8.dp)
                        .widthIn(max = 200.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    legendCuisines.forEach { cuisine ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            Box(Modifier.size(10.dp).background(cuisine.color(), CircleShape))
                            Text(cuisine.label(), style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }
        if (withCoords.isEmpty()) {
            Text(
                stringResource(R.string.map_no_coords),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(12.dp)
                    .background(
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                        RoundedCornerShape(6.dp),
                    )
                    .padding(8.dp),
            )
        }
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

private fun markerIcon(context: Context, color: androidx.compose.ui.graphics.Color): Drawable {
    val size = 72
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    val radius = size / 2f - 6f
    val fill = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color.toArgb()
        style = Paint.Style.FILL
    }
    val stroke = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = android.graphics.Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 6f
    }
    canvas.drawCircle(size / 2f, size / 2f, radius, fill)
    canvas.drawCircle(size / 2f, size / 2f, radius, stroke)
    return BitmapDrawable(context.resources, bitmap)
}
