import androidx.room.*

@Dao
interface FavoriteDao {
    // Insert a favorite route
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    // Get all favorite routes
    @Query("SELECT * FROM favorite")
    fun getFavorites(): List<Favorite>
}