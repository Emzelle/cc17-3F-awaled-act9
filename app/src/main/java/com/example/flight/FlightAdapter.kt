import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flight.R

class FlightAdapter : ListAdapter<Airport, FlightAdapter.FlightViewHolder>(FLIGHT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name, current.iata_code)
    }

    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val codeTextView: TextView = itemView.findViewById(R.id.codeTextView)

        fun bind(name: String, iataCode: String) {
            nameTextView.text = name
            codeTextView.text = iataCode
        }
    }

    companion object {
        private val FLIGHT_COMPARATOR = object : DiffUtil.ItemCallback<Airport>() {
            override fun areItemsTheSame(oldItem: Airport, newItem: Airport): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Airport, newItem: Airport): Boolean {
                return oldItem == newItem
            }
        }
    }
}
