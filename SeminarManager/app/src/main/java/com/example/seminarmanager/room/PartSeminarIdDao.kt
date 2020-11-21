package com.example.seminarmanager.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PartSeminarIdDao {

    @Query("SELECT * FROM seminar_id_table")
    fun getAll(): List<PartSeminarId>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seminar_id: PartSeminarId)

}