package com.example.seminarmanager.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.api.User
import com.example.seminarmanager.ui.detailseminar.InstructorListAdapter
import com.example.seminarmanager.ui.detailseminar.ParticipantListAdapter
import com.example.seminarmanager.ui.main.InstSeminarAdapter
import com.example.seminarmanager.ui.main.PartSeminarAdapter
import com.example.seminarmanager.ui.main.SeminarAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: SeminarAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: InstSeminarAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: PartSeminarAdapter) {
    view.adapter = adapter
}


@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: InstructorListAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: ParticipantListAdapter) {
    view.adapter = adapter
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, seminar: List<SimpleSeminar>?) {
    val adapter = view.adapter as? SeminarAdapter
    if (seminar != null) {
        adapter?.setItems(seminar)
    }
}

@BindingAdapter("items")
fun bindInstSeminarItems(view: RecyclerView, seminar: List<Seminar>?) {
    val adapter = view.adapter as? InstSeminarAdapter
    if (seminar != null) {
        adapter?.setItems(seminar)
    }
}

@BindingAdapter("items")
fun bindPartSeminarItems(view: RecyclerView, seminar: List<Seminar>?) {
    val adapter = view.adapter as? PartSeminarAdapter
    if (seminar != null) {
        adapter?.setItems(seminar)
    }
}

@BindingAdapter("items")
fun bindInstItems(view: RecyclerView, inst: List<User>?) {
    val adapter = view.adapter as? InstructorListAdapter
    if (inst != null) {
        adapter?.setItems(inst)
    }
}

@BindingAdapter("items")
fun bindPartItems(view: RecyclerView, part: List<User>?) {
    val adapter = view.adapter as? ParticipantListAdapter
    if (part != null) {
        adapter?.setItems(part)
    }
}