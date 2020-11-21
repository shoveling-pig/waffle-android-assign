package com.example.seminarmanager.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.repository.SeminarRepository
import com.example.seminarmanager.repository.UserRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class PartSeminarIdViewModel(private val repository: PartSeminarIdRepository) : ViewModel() {

    fun getAllIds() = repository.getAllIds()

    fun insertId(id: Long) {
        repository.insertId(PartSeminarId(id))
    }

}