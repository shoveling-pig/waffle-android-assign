package com.example.seminarmanager.ui.main

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.api.InstNameList
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.databinding.ItemSimpleSeminarBinding
import com.example.seminarmanager.room.PartSeminarIdViewModel
import kotlinx.android.synthetic.main.item_simple_seminar.view.*
import java.lang.Exception

class SeminarAdapter(private val partViewModel: PartSeminarIdViewModel) : RecyclerView.Adapter<SeminarViewHolder>() {
    private val items = mutableListOf<SimpleSeminar>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        val binding = ItemSimpleSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeminarViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)

        val username = SeminarManagerApplication.prefs.getString("user_username_key", "none")
        item.instructors.forEach {
            if (it.username == username) {
                holder.itemView.card_view.setBackgroundColor(Color.parseColor("#dcedc8"))
                return
            }
        }
        try {
            val thread = Thread(Runnable {
                var partSeminarIds = partViewModel.getAllIds()
                partSeminarIds.forEach {
                    if (it.id == item.id) {
                        holder.itemView.card_view.setBackgroundColor(Color.parseColor("#b3e5fc"))
                    }
                }
            })
            thread.start()
        } catch (e: Exception) { e.printStackTrace() }

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

        var instNameList = mutableListOf<String>()
        seminar.instructors.forEach {
            instNameList.add(it.username)
        }
        binding.itemInstList = InstNameList(instNameList.joinToString(separator = ","))
    }
}