import androidx.room.*

@Dao
interface AirportDao {
    // Autocomplete search for airports
    @Query("SELECT * FROM airport WHERE iata_code LIKE :query OR name LIKE :query ORDER BY passengers DESC")
    fun searchAirports(query: String): List<Airport>

    // Get flights departing from a selected airport
    @Query("SELECT * FROM airport WHERE iata_code != :departureCode")
    fun getFlightsFrom(departureCode: String): List<Airport>

}
