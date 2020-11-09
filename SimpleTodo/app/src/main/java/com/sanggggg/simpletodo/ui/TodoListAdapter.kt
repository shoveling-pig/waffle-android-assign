package com.sanggggg.simpletodo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sanggggg.simpletodo.databinding.ItemTodoBinding
import com.sanggggg.simpletodo.room.Todo
import com.sanggggg.simpletodo.viewmodel.TodoViewModel

class TodoListAdapter(private val viewModel: TodoViewModel) : RecyclerView.Adapter<TodoViewHolder>() {
    private val items = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindTodo(items[position])
    }

    fun setItems(todos: List<Todo>) {
        items.clear()
        items.addAll(todos)
        notifyDataSetChanged()
    }
}

class TodoViewHolder(private val binding: ItemTodoBinding, private val viewModel: TodoViewModel) : RecyclerView.ViewHolder(binding.root) {

    fun bindTodo(todo: Todo) {
        binding.item = todo
        binding.button.setOnClickListener { viewModel.deleteTodo(todo) }
    }
}