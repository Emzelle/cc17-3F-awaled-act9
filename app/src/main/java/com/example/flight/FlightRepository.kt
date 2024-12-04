import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: PreferencesDataStore by preferencesDataStore("search_preferences")

object DataStoreManager {
    private val SEARCH_TEXT = stringPreferencesKey("search_text")

    fun getSearchText(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[SEARCH_TEXT]
        }
    }

    suspend fun saveSearchText(context: Context, searchText: String) {
        context.dataStore.edit { preferences ->
            preferences[SEARCH_TEXT] = searchText
        }
    }
}
