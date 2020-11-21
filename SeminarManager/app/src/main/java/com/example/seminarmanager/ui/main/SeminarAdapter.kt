package com.example.seminarmanager.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.databinding.ItemSimpleSeminarBinding
import kotlinx.android.synthetic.main.item_simple_seminar.view.*

class SeminarAdapter : RecyclerView.Adapter<SeminarViewHolder>() {
    private val items = mutableListOf<SimpleSeminar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        val binding = ItemSimpleSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeminarViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)

        holder.itemView.card_view.setBackgroundColor(Color.parseColor("#dcedc8"))
        holder.itemView.card_view.setBackgroundColor(Color.parseColor("#b3e5fc"))
    }

    fun setItems(seminars: List<SimpleSeminar>) {
        items.clear()
        items.addAll(seminars)
        notifyDataSetChanged()
    }
}

class SeminarViewHolder(private val binding: ItemSimpleSeminarBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(seminar: SimpleSeminar) {
        binding.item = seminar
    }
}