package com.sanggggg.simpletodo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanggggg.simpletodo.room.Todo
import com.sanggggg.simpletodo.room.TodoRepository
import com.sanggggg.simpletodo.ui.TodoListAdapter
import com.sanggggg.simpletodo.utils.bindAdapter
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    var allTodos: LiveData<List<Todo>> = repository.getAllTodos()

    fun checkTodo() {
        allTodos = repository.getAllTodos()
    }

    fun addTodo(title: String, content: String) {
        viewModelScope.launch { repository.insertTodo(Todo(title, content)) }
        checkTodo()
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch { repository.deleteTodo(todo) }
        checkTodo()
    }

}