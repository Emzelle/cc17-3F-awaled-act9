import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flight.R
import kotlinx.android.synthetic.main.airport_item.view.*

class AirportAdapter(private val onFavoriteClick: (Favorite) -> Unit) :
    RecyclerView.Adapter<AirportAdapter.AirportViewHolder>() {

    private val airports = mutableListOf<Airport>()

    fun submitList(newAirports: List<Airport>) {
        airports.clear()
        airports.addAll(newAirports)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
        return AirportViewHolder(view)
    }

    override fun onBindViewHolder(holder: AirportViewHolder, position: Int) {
        holder.bind(airports[position], onFavoriteClick)
    }

    override fun getItemCount(): Int = airports.size

    class AirportViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(airport: Airport, onFavoriteClick: (Favorite) -> Unit) {
            view.airportName.text = "${airport.iata_code} - ${airport.name}"
            view.favoriteButton.setOnClickListener {
                val favorite = Favorite(0, "USER_SELECTED_DEPARTURE", airport.iata_code)
                onFavoriteClick(favorite)
            }
        }
    }
}
