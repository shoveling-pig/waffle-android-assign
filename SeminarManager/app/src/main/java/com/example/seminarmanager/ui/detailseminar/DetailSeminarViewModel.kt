package com.example.seminarmanager.ui.detailseminar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.api.User
import com.example.seminarmanager.repository.SeminarRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailSeminarViewModel(private val repository: SeminarRepository) : ViewModel() {
    val theSeminar: MutableLiveData<Seminar> = MutableLiveData()
    val allInstructor: MutableLiveData<List<User>> = MutableLiveData()
    val allParticipant: MutableLiveData<List<User>> = MutableLiveData()

    fun setSeminar(seminarId: Long) {
        val response = repository.getSeminar(seminarId)
        response.subscribeOn(Schedulers.io())
            .subscribe { seminar ->
                theSeminar.postValue(seminar)
                allInstructor.postValue(seminar.instructors)
                allParticipant.postValue(seminar.participants)

                val dummyUser = User(-1, "Empty", "","","","", null, null,"")
                if (seminar.instructors == null) {
                    allInstructor.postValue(listOf(dummyUser))
                }
                if (seminar.participants == null) {
                    allParticipant.postValue(listOf(dummyUser))
                }
            }
    }

    fun joinSeminar(seminarId: Long) {
        repository.joinSeminar(seminarId)
    }
}