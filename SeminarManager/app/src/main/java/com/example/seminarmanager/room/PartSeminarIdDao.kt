package com.example.seminarmanager.room

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.rxjava3.core.Single

@Dao
interface PartSeminarIdDao {

    @Query("SELECT * FROM seminar_id_table")
    fun getAll(): List<PartSeminarId>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seminar_id: PartSeminarId)

}