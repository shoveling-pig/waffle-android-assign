package com.example.seminarmanager.repository

import com.example.seminarmanager.api.SeminarService
import io.reactivex.rxjava3.schedulers.Schedulers

class SeminarRepository(private val service: SeminarService) {
    fun createSeminar(name: String, capacity: String, count: String, time:String, online:String): Long {
        var seminarId:Long = -1L

        val response = service.postSeminar(name, capacity, count, time, online)
        response.subscribeOn(Schedulers.io())
            .subscribe { seminar ->
                seminarId = seminar.id
            }
        return seminarId
    }

    fun getSeminar(seminarId: Long) = service.getSeminar(seminarId)

    fun joinSeminar(seminarId: Long) = service.joinSeminar(seminarId)

    fun getSeminarList() = service.getSeminarList("", "")
}