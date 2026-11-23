package de.p2pfood.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val region: RegionConfig? = null,
    val restaurants: List<Restaurant> = emptyList(),
    val filtered: List<Restaurant> = emptyList(),
    val selectedCuisines: Set<Cuisine> = emptySet(),
    val selectedOrderTypes: Set<OrderType> = emptySet(),
    val deliversOnly: Boolean = false,
)

class HomeViewModel(
    private val repository: RestaurantRepository,
    catalog: RegionCatalog,
) : ViewModel() {

    private val regions: Map<String, RegionConfig> =
        catalog.availableRegionIds().associateWith { catalog.loadRegion(it) }

    private val _selectedRegionId = MutableStateFlow(regions.keys.first())
    val selectedRegionId: StateFlow<String> = _selectedRegionId.asStateFlow()

    private val _selectedCuisines = MutableStateFlow<Set<Cuisine>>(emptySet())
    private val _selectedOrderTypes = MutableStateFlow<Set<OrderType>>(emptySet())
    private val _deliversOnly = MutableStateFlow(false)

    val uiState: StateFlow<HomeUiState> = combine(
        _selectedRegionId,
        _selectedCuisines,
        _selectedOrderTypes,
        _deliversOnly,
        _selectedRegionId.flatMapLatest { id -> repository.observeRestaurants(id) },
    ) { regionId, cuisines, orderTypes, deliversOnly, restaurants ->
        HomeUiState(
            region = regions[regionId],
            restaurants = restaurants,
            filtered = restaurants.filter { r ->
                (cuisines.isEmpty() || r.cuisines.any { it in cuisines }) &&
                    (orderTypes.isEmpty() || r.orderTypes.any { it in orderTypes }) &&
                    (!deliversOnly || r.delivers)
            },
            selectedCuisines = cuisines,
            selectedOrderTypes = orderTypes,
            deliversOnly = deliversOnly,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeUiState())

    init {
        viewModelScope.launch {
            regions.keys.forEach { repository.ensureRegionSeeded(it) }
        }
    }

    fun selectRegion(regionId: String) {
        _selectedRegionId.value = regionId
    }

    fun toggleCuisine(cuisine: Cuisine) {
        _selectedCuisines.update { if (cuisine in it) it - cuisine else it + cuisine }
    }

    fun toggleOrderType(orderType: OrderType) {
        _selectedOrderTypes.update { if (orderType in it) it - orderType else it + orderType }
    }

    fun setDeliversOnly(value: Boolean) {
        _deliversOnly.value = value
    }
}

fun homeViewModelFactory(container: AppContainer) = viewModelFactory {
    initializer {
        HomeViewModel(container.restaurantRepository, container.regionCatalog)
    }
}
