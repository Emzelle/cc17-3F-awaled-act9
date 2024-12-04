import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlightViewModel(application: Application) : AndroidViewModel(application) {
    private val database = FlightDatabase.getDatabase(application)
    private val dao = database.flightDao()

    private val _airports = MutableStateFlow<List<Airport>>(emptyList())
    val airports: StateFlow<List<Airport>> = _airports

    private val _favorites = MutableStateFlow<List<Favorite>>(emptyList())
    val favorites: StateFlow<List<Favorite>> = _favorites

    fun searchAirports(query: String) {
        viewModelScope.launch {
            val result = dao.searchAirports("%$query%")
            _airports.value = result
        }
    }

    fun getFlightsFrom(departureCode: String) {
        viewModelScope.launch {
            val result = dao.getFlightsFrom(departureCode)
            _airports.value = result
        }
    }

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = dao.getFavorites()
        }
    }

    fun addFavorite(favorite: Favorite) {
        viewModelScope.launch {
            dao.insertFavorite(favorite)
            loadFavorites()
        }
    }
}
