package com.example.seminarmanager.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.databinding.ItemSeminarBinding

class PartSeminarAdapter(val listener: (Seminar) -> Unit) : RecyclerView.Adapter<PartSeminarViewHolder>() {
    private val items = mutableListOf<Seminar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartSeminarViewHolder {
        val binding = ItemSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PartSeminarViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PartSeminarViewHolder, position: Int) {
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

class PartSeminarViewHolder(private val binding: ItemSeminarBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(seminar: Seminar) {
        binding.item = seminar
    }
}