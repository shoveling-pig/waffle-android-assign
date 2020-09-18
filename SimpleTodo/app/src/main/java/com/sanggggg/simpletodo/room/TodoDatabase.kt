package com.sanggggg.simpletodo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// Already completed
@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        @JvmStatic
        fun getInstance(context: Context) : TodoDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "todo_db"
            ).build()
        }
    }
}