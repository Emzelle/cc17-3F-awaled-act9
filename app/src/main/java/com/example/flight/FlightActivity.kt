import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flight.R

class FlightActivity : AppCompatActivity() {

    private val flightViewModel: FlightViewModel by viewModels {
        FlightViewModelFactory((application as FlightApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FlightAdapter()
        recyclerView.adapter = adapter

        flightViewModel.allAirports.observe(this) { airports ->
            airports?.let {
                adapter.submitList(it)
            }
        }
    }
}
