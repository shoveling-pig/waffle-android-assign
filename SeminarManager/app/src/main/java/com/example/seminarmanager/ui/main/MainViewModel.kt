package com.example.seminarmanager.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.api.SimpleSeminar
import com.example.seminarmanager.repository.SeminarRepository
import com.example.seminarmanager.repository.UserRepository
import com.example.seminarmanager.room.PartSeminarIdRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val seminarRepo: SeminarRepository, private val userRepo: UserRepository) : ViewModel() {
    val allSimpleSeminar: MutableLiveData<List<SimpleSeminar>> = MutableLiveData()
    val instSeminar: MutableLiveData<List<Seminar>> = MutableLiveData()
    val partSeminar: MutableLiveData<List<Seminar>> = MutableLiveData()

    fun setSeminarList() {
        val response =seminarRepo.getSeminarList()
        response.subscribeOn(Schedulers.io())
            .subscribe { simpleSeminar ->
                allSimpleSeminar.postValue(simpleSeminar)
            }

        Log.d("WAFFLE_DEBUG", "seminar fragment ${allSimpleSeminar.value.toString()}")
        Log.d("WAFFLE_DEBUG", "user fragment - inst ${instSeminar.value.toString()}")
        Log.d("WAFFLE_DEBUG", "user fragment - part ${partSeminar.value.toString()}")
    }

    fun getUserInfo() {
        val response = userRepo.getUserInfo()
        response.subscribeOn(Schedulers.io())
                .subscribe ({ user ->
                    instSeminar.postValue(user.instructor?.charge)
                    partSeminar.postValue(user.participant?.seminars)
                }, { error ->
                    error.printStackTrace()
                })
    }

    fun editUserInfo(username: String, firstname: String, lastname: String)
        = userRepo.editUserInfo(username, firstname, lastname)
}