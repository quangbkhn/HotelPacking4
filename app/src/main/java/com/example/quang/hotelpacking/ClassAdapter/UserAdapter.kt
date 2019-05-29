package com.example.quang.hotelpacking.ClassAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quang.hotelpacking.Class.User
import com.example.quang.hotelpacking.R

class UserAdapter(var context: Context?, var ListUser:List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val txt:View = LayoutInflater.from(parent.context).inflate(R.layout.user_interface,parent,false)
        return UserViewHolder(txt)
    }

    override fun getItemCount(): Int {
        return ListUser.size
    }

    override fun onBindViewHolder(p0: UserViewHolder, p1: Int) {
        val itemView = p0.itemView
        val room = itemView.findViewById<TextView>(R.id.txt_sroom)
        room.text = ListUser[p1].Order.toString()
        val  xe =itemView.findViewById<TextView>(R.id.txt_stime)
        xe.text=ListUser[p1].E_Bike
        val time = itemView.findViewById<TextView>(R.id.txt_stime)
        time.text=ListUser[p1].time
        val cost = itemView.findViewById<TextView>(R.id.txt_stime)
        cost.text = ListUser[p1].Services

    }

    class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}