package com.sanggggg.simpletodo.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

}