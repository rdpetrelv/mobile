package com.laundryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.R
import com.laundryapp.interfaces.OnRoomClickListener
import com.laundryapp.model.SensorDto

class SensorsAdapter(val listener: OnRoomClickListener) : RecyclerView.Adapter<SensorsAdapter.RoomsViewHolder>() { // (1)

    inner class RoomsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_sensor_id)
        val currentTemperature: TextView = view.findViewById(R.id.txt_current_temperature_value)
    }

    private val items = mutableListOf<SensorDto>() // (3)

    fun setItems(rooms: List<SensorDto>) {  // (4)
        items.clear()
        items.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rooms_item, parent, false)
        return RoomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {  // (7)
        val roomDto = items[position]
        holder.apply {
            name.text = roomDto.sensorName
            currentTemperature.text = roomDto.measure.toString()
            itemView.setOnClickListener { listener.selectRoom2(roomDto.sensorId, roomDto.sensorName, roomDto.sensorType, roomDto.measure) }
        }
    }
    override fun onViewRecycled(holder: RoomsViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }
    }
}