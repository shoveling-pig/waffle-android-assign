package com.example.seminarmanager.ui.signup

import androidx.lifecycle.ViewModel
import com.example.seminarmanager.repository.UserRepository

class SignUpViewModel(private val repository: UserRepository) : ViewModel() {
    fun signUp(username:String, password:String, email:String, firstname:String, lastname:String, role:String, company:String, year:String, university:String, accepted:String)
            = repository.signUp(username, password, email, firstname, lastname, role, company, year, university, accepted)
}