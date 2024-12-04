import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AirportDao {
    @Query("SELECT * FROM airport WHERE iata_code = :iataCode")
    suspend fun getFlightsByDeparture(iataCode: String): List<Airport>

    @Query("SELECT * FROM airport")
    fun getAllAirports(): LiveData<List<Airport>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirport(airport: Airport)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirports(airports: List<Airport>)

    @Delete
    suspend fun deleteAirport(airport: Airport)
}

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    fun getFavorites(): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}
