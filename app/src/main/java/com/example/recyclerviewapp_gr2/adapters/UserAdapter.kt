package com.example.recyclerviewapp_gr2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp_gr2.R
import com.example.recyclerviewapp_gr2.databinding.UserItemBinding
import com.example.recyclerviewapp_gr2.models.User

class UserAdapter(private val usersList : List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = UserItemBinding.inflate(inflater,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = usersList[position]
        holder.bindUserToLayout(user)
    }

    class UserViewHolder(private val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindUserToLayout(userParam: User) {
            binding.user = userParam
            binding.executePendingBindings()
        }
    }
}