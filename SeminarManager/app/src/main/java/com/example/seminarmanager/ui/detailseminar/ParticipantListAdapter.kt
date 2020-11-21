package com.example.seminarmanager.ui.detailseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.User
import com.example.seminarmanager.databinding.ItemUserBinding

class ParticipantListAdapter : RecyclerView.Adapter<ParticipantViewHolder>() {
    private val items = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParticipantViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    fun setItems(participants: List<User>) {
        items.clear()
        items.addAll(participants)
        notifyDataSetChanged()
    }
}

class ParticipantViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(part: User) {
        binding.item = part
    }
}