import androidx.room.*

@Dao
interface AirportDao {
    // Query to fetch favorite flights
    @Query("SELECT * FROM favorite")
    suspend fun getFavorites(): List<Favorite>

    // Insert a favorite flight
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    // Example query for searching airports
    @Query("SELECT * FROM airport WHERE name LIKE :query OR iata_code LIKE :query")
    suspend fun searchAirports(query: String): List<Airport>

    // Query to get flights from a specific departure code
    @Query("SELECT * FROM airport WHERE iata_code = :departureCode")
    suspend fun getFlightsFrom(departureCode: String): List<Airport>
}
