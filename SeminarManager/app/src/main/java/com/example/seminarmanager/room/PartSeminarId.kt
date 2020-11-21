package com.example.seminarmanager.room

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey

@Entity(tableName = "seminar_id_table")
data class PartSeminarId(
    @ColumnInfo(name = "seminar_id")
    var seminar_id: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}