package com.example.quang.hotelpacking.ClassAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quang.hotelpacking.Class.Vehicle
import com.example.quang.hotelpacking.R

class VehicleAdapter(var context: Context?, var ListVehicle:List<Vehicle>):RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val txt = LayoutInflater.from(parent.context).inflate(R.layout.list_interface,parent,false)
        return  VehicleViewHolder(txt)
    }

    override fun getItemCount(): Int {
        return ListVehicle.size
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val itemView = holder.itemView
        val idbike = itemView.findViewById<TextView>(R.id.id_bike)
        idbike.text = """ID BIKE${ListVehicle[position].id}"""
        val dock = itemView.findViewById<TextView>(R.id.dock_bike)
        dock.text = """DOCK BIKE${ListVehicle[position].E_Bike}"""

    }

    class VehicleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}