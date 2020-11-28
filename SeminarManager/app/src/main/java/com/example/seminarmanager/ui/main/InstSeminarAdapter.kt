package com.example.seminarmanager.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.api.User
import com.example.seminarmanager.databinding.ItemSeminarBinding
import com.example.seminarmanager.databinding.ItemUserBinding

class InstSeminarAdapter(val listener: (Seminar) -> Unit) : RecyclerView.Adapter<InstSeminarViewHolder>() {
    private val items = mutableListOf<Seminar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstSeminarViewHolder {
        val binding = ItemSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InstSeminarViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: InstSeminarViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    fun setItems(seminars: List<Seminar>) {
        items.clear()
        items.addAll(seminars)
        notifyDataSetChanged()
    }
}

class InstSeminarViewHolder(private val binding: ItemSeminarBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(seminar: Seminar) {
        binding.item = seminar
    }
}