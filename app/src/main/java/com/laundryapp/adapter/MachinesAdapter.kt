package com.laundryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laundryapp.R
import com.laundryapp.interfaces.OnMachineClickListener
import com.laundryapp.model.MachinesDto

class MachinesAdapter(val listener: OnMachineClickListener) : RecyclerView.Adapter<MachinesAdapter.MachinesViewHolder>()  {

    inner class MachinesViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val user: TextView = view.findViewById(R.id.txt_reservation_user_listed)
        val reservation_statuss: TextView = view.findViewById(R.id.txt_reservation_statuss)
        val reservation_date: TextView = view.findViewById(R.id.txt_reservation_from2)
    }
    private val items = mutableListOf<MachinesDto>() // (3)

    fun setItems(rooms: List<MachinesDto>) {  // (4)
        items.clear()
        items.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachinesAdapter.MachinesViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_machines_item, parent, false)
        return MachinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MachinesAdapter.MachinesViewHolder, position: Int) {  // (7)
        val roomDto = items[position]
        holder.apply {
            user.text = roomDto.name
            reservation_statuss.text = roomDto.available.toString()
            reservation_date.text = roomDto.progress.toString()
            itemView.setOnClickListener { listener.selectMachine2(roomDto.machineId,roomDto.name,roomDto.available,roomDto.machineStatus,roomDto.progress,
            ) }
        }
    }

    override fun onViewRecycled(holder: MachinesAdapter.MachinesViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }

    }

}