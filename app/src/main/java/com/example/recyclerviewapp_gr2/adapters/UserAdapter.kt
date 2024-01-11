package com.example.recyclerviewapp_gr2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp_gr2.R
import com.example.recyclerviewapp_gr2.models.User

class UserAdapter(private val usersList : List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = usersList[position]
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
//        holder.tvEmail.text = user.email
//        holder.tvCity.text = user.address.city
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvUsername : TextView = itemView.findViewById(R.id.tvUsername)
//        val tvEmail : TextView = itemView.findViewById(R.id.tvEmail)
//        val tvCity : TextView = itemView.findViewById(R.id.tvCity)
    }
}