import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
    // Query to fetch favorite flights
    @Query("SELECT * FROM favorite")
    fun getFavorites(): Flow<List<Favorite>>

    // Insert a favorite flight
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(favorites: List<Favorite>)


    // Example query for searching airports
    @Query("SELECT * FROM airport WHERE name LIKE :query OR iata_code LIKE :query")
    fun searchAirports(query: String): List<Airport> // Use a supported return type

    // Query to get flights from a specific departure code
    @Query("SELECT * FROM airport WHERE iata_code = :departureCode")
    fun getFlightsFrom(departureCode: String): Flow<List<Airport>>
}
