import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FlightViewModel(private val repository: FlightRepository) : ViewModel() {

    val allAirports: LiveData<List<Airport>> = repository.allAirports
    val favoriteFlights: LiveData<List<Favorite>> = repository.favoriteFlights

    fun getFlightsByDeparture(iataCode: String, onResult: (List<Airport>) -> Unit) {
        viewModelScope.launch {
            val result = repository.getFlightsByDeparture(iataCode)
            onResult(result)
        }
    }

    fun insertAirport(airport: Airport) = viewModelScope.launch {
        repository.insertAirport(airport)
    }

    fun insertFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.insertFavorite(favorite)
    }

    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.deleteFavorite(favorite)
    }
}
