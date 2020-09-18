package com.sanggggg.simpletodo.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sanggggg.simpletodo.room.Todo
import com.sanggggg.simpletodo.ui.TodoListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, todo: List<Todo>?) {
    val adapter = view.adapter as? TodoListAdapter
    if (todo != null) {
        adapter?.setItems(todo)
    }
}