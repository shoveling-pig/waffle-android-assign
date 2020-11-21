package com.example.seminarmanager.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.databinding.ItemSimpleSeminarBinding

class SeminarAdapter : RecyclerView.Adapter<SeminarViewHolder>() {
    private val items = mutableListOf<SimpleSeminar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        val binding = ItemSimpleSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeminarViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        holder.bindItem(items[position])
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