package de.p2pfood.app.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.p2pfood.app.data.AppContainer
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.region.RegionCatalog
import de.p2pfood.app.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: RestaurantRepository,
    private val catalog: RegionCatalog,
    private val restaurantId: String,
) : ViewModel() {

    private val _restaurant = MutableStateFlow<Restaurant?>(null)
    val restaurant: StateFlow<Restaurant?> = _restaurant.asStateFlow()

    private val _reportUrl = MutableStateFlow<String?>(null)
    val reportUrl: StateFlow<String?> = _reportUrl.asStateFlow()

    val isFavorite: StateFlow<Boolean> = repository.observeFavoriteIds()
        .map { restaurantId in it }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    init {
        viewModelScope.launch {
            val r = repository.getRestaurant(restaurantId)
            _restaurant.value = r
            _reportUrl.value = r?.let { catalog.loadRegion(it.regionId).reportUrl }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch { repository.toggleFavorite(restaurantId) }
    }
}

fun detailViewModel(container: AppContainer, restaurantId: String) = DetailViewModel(
    container.restaurantRepository,
    container.regionCatalog,
    restaurantId,
)
