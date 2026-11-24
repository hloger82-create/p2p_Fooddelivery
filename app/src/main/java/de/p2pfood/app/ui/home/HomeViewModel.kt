package de.p2pfood.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import de.p2pfood.app.data.AppContainer
import de.p2pfood.app.data.model.Cuisine
import de.p2pfood.app.data.model.OrderType
import de.p2pfood.app.data.model.RegionConfig
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.region.RegionCatalog
import de.p2pfood.app.data.repository.RestaurantRepository
import de.p2pfood.app.util.OpeningHours
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Filters(
    val query: String = "",
    val postcode: String = "",
    val cuisines: Set<Cuisine> = emptySet(),
    val orderTypes: Set<OrderType> = emptySet(),
    val deliversOnly: Boolean = false,
    val favoritesOnly: Boolean = false,
    val openNow: Boolean = false,
)

data class HomeUiState(
    val region: RegionConfig? = null,
    val restaurants: List<Restaurant> = emptyList(),
    val filtered: List<Restaurant> = emptyList(),
    val filters: Filters = Filters(),
    val favoriteIds: Set<String> = emptySet(),
)

class HomeViewModel(
    private val repository: RestaurantRepository,
    catalog: RegionCatalog,
) : ViewModel() {

    private val regions: Map<String, RegionConfig> =
        catalog.availableRegionIds().associateWith { catalog.loadRegion(it) }

    private val _selectedRegionId = MutableStateFlow(regions.keys.first())
    val selectedRegionId: StateFlow<String> = _selectedRegionId.asStateFlow()

    private val _filters = MutableStateFlow(Filters())

    val uiState: StateFlow<HomeUiState> = combine(
        _selectedRegionId,
        _filters,
        _selectedRegionId.flatMapLatest { id -> repository.observeRestaurants(id) },
        repository.observeFavoriteIds(),
    ) { regionId, filters, restaurants, favoriteIds ->
        HomeUiState(
            region = regions[regionId],
            restaurants = restaurants,
            favoriteIds = favoriteIds,
            filters = filters,
            filtered = restaurants.filter { r ->
                val q = filters.query.trim().lowercase()
                (q.isEmpty() ||
                    r.name.lowercase().contains(q) ||
                    r.cuisines.any { it.name.lowercase().contains(q) }) &&
                    (filters.cuisines.isEmpty() || r.cuisines.any { it in filters.cuisines }) &&
                    (filters.orderTypes.isEmpty() || r.orderTypes.any { it in filters.orderTypes }) &&
                    (!filters.deliversOnly || r.delivers) &&
                    (filters.postcode.isBlank() || deliversTo(r, filters.postcode.trim())) &&
                    (!filters.favoritesOnly || r.id in favoriteIds) &&
                    (!filters.openNow || OpeningHours.isOpen(r.openingHours) == true)
            },
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeUiState())

    init {
        viewModelScope.launch {
            regions.keys.forEach {
                repository.ensureRegionSeeded(it)
                repository.syncRemoteDataset(it)
            }
        }
    }

    private fun deliversTo(r: Restaurant, plz: String): Boolean =
        r.delivers && (r.deliveryAreas.isEmpty() || r.deliveryAreas.any { area -> area.contains(plz) })

    fun selectRegion(regionId: String) {
        _selectedRegionId.value = regionId
    }

    fun setQuery(query: String) {
        _filters.update { it.copy(query = query) }
    }

    fun setPostcode(postcode: String) {
        _filters.update { it.copy(postcode = postcode.filter { c -> c.isDigit() }.take(5)) }
    }

    fun toggleCuisine(cuisine: Cuisine) {
        _filters.update {
            it.copy(cuisines = if (cuisine in it.cuisines) it.cuisines - cuisine else it.cuisines + cuisine)
        }
    }

    fun toggleOrderType(orderType: OrderType) {
        _filters.update {
            it.copy(orderTypes = if (orderType in it.orderTypes) it.orderTypes - orderType else it.orderTypes + orderType)
        }
    }

    fun setDeliversOnly(value: Boolean) {
        _filters.update { it.copy(deliversOnly = value) }
    }

    fun toggleFavoritesOnly() {
        _filters.update { it.copy(favoritesOnly = !it.favoritesOnly) }
    }

    fun toggleOpenNow() {
        _filters.update { it.copy(openNow = !it.openNow) }
    }

    fun toggleFavorite(restaurantId: String) {
        viewModelScope.launch { repository.toggleFavorite(restaurantId) }
    }
}

fun homeViewModelFactory(container: AppContainer) = viewModelFactory {
    initializer {
        HomeViewModel(container.restaurantRepository, container.regionCatalog)
    }
}
