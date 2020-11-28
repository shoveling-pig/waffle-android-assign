package com.example.seminarmanager.room

import android.content.Context
import androidx.lifecycle.LiveData
import java.lang.Exception

class PartSeminarIdRepository(context: Context) {

    private val dao: PartSeminarIdDao by lazy {
        PartSeminarIdDatabase.getInstance(context).partSeminarIdDao()
    }

    fun getAllIds() = dao.getAll()

    fun insertId(id: PartSeminarId) {
        try {
            val thread = Thread(Runnable {
                dao.insert(id)
            })
            thread.start()
        } catch (e: Exception) { e.printStackTrace() }
    }
}