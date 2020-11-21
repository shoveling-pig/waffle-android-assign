package com.example.seminarmanager.ui.detailseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.User
import com.example.seminarmanager.databinding.ItemUserBinding

class InstructorListAdapter : RecyclerView.Adapter<InstructorViewHolder>() {
    private val items = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstructorViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InstructorViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: InstructorViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    fun setItems(instructors: List<User>) {
        items.clear()
        items.addAll(instructors)
        notifyDataSetChanged()
    }
}

class InstructorViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(inst: User) {
        binding.item = inst
    }
}