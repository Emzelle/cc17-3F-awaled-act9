import android.app.Application

class FlightApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { FlightRepository(database.FlightDao()) }
}
