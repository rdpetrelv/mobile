package com.laundryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.R
import com.laundryapp.interfaces.OnReservationClickListener
import com.laundryapp.interfaces.OnRoomClickListener
import com.laundryapp.model.ReservationDto

class ReservationsAdapter(val listener: OnReservationClickListener) : RecyclerView.Adapter<ReservationsAdapter.ReservationsViewHolder>() {

    inner class ReservationsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val user: TextView = view.findViewById(R.id.txt_reservation_user_listed)
        val reservation_statuss: TextView = view.findViewById(R.id.txt_reservation_statuss)
        val reservation_date: TextView = view.findViewById(R.id.txt_reservation_from2)
    }

    private val items = mutableListOf<ReservationDto>() // (3)

    fun setItems(rooms: List<ReservationDto>) {  // (4)
        items.clear()
        items.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_reservations_item, parent, false)
        return ReservationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationsViewHolder, position: Int) {  // (7)
        val roomDto = items[position]
        holder.apply {
            user.text = roomDto.reservationUser
            reservation_statuss.text = roomDto.reservationAvailable.toString()
            reservation_date.text = roomDto.reservationDate
            itemView.setOnClickListener { listener.selectReservation2(roomDto.reservationId, roomDto.reservationUser, roomDto.reservationDate, roomDto.reservationStartTime, roomDto.reservationEndTime, roomDto.reservationAvailable) }
        }
    }

    override fun onViewRecycled(holder: ReservationsViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }

    }
}