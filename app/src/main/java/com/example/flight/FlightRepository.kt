import androidx.lifecycle.LiveData

class FlightRepository(private val airportDao: AirportDao, private val favoriteDao: FavoriteDao) {

    val allAirports: LiveData<List<Airport>> = airportDao.getAllAirports()
    val favoriteFlights: LiveData<List<Favorite>> = favoriteDao.getFavorites()

    suspend fun getFlightsByDeparture(iataCode: String): List<Airport> {
        return airportDao.getFlightsByDeparture(iataCode)
    }

    suspend fun insertAirport(airport: Airport) {
        airportDao.insertAirport(airport)
    }

    suspend fun insertAirports(airports: List<Airport>) {
        airportDao.insertAirports(airports)
    }

    suspend fun insertFavorite(favorite: Favorite) {
        favoriteDao.insertFavorite(favorite)
    }

    suspend fun deleteFavorite(favorite: Favorite) {
        favoriteDao.deleteFavorite(favorite)
    }
}
