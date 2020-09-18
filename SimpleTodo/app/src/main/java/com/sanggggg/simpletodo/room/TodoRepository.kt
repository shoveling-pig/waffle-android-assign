package com.sanggggg.simpletodo.room

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import java.lang.Exception

class TodoRepository(context: Context) {

    val todoDao: TodoDao by lazy {
        TodoDatabase.getInstance(context).todoDao()
    }

    fun getAllTodos(): LiveData<List<Todo>> = todoDao.getAllTodos()

    fun insertTodo(todo: Todo) {
        try {
            val thread = Thread(Runnable {
                todoDao.insertTodo(todo)
            })
            thread.start()
        } catch (e: Exception) { e.printStackTrace() }
    }

    fun deleteTodo(todo: Todo) {
        try {
            val thread = Thread(Runnable {
                todoDao.deleteTodo(todo)
            })
            thread.start()
        } catch (e: Exception) { e.printStackTrace() }
    }
}