package com.example.seminarmanager.ui.createseminar

import androidx.lifecycle.ViewModel
import com.example.seminarmanager.repository.SeminarRepository

class CreateSeminarViewModel(private val repository: SeminarRepository) : ViewModel() {
    fun createSeminar(name:String, capacity:String, count:String, time:String, online:String)
        = repository.createSeminar(name, capacity, count, time, online)
}