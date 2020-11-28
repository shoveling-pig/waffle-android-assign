package com.example.seminarmanager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PartSeminarId::class], version = 1, exportSchema = false)
abstract class PartSeminarIdDatabase : RoomDatabase() {

    abstract fun partSeminarIdDao(): PartSeminarIdDao

    companion object {
        @Volatile
        private var INSTANCE: PartSeminarIdDatabase? = null

        @JvmStatic
        fun getInstance(context: Context) : PartSeminarIdDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                PartSeminarIdDatabase::class.java,
                "seminar_id_db"
            ).build()
        }
    }
}