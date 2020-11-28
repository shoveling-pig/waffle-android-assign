package com.example.seminarmanager.ui.login

import androidx.lifecycle.ViewModel
import com.example.seminarmanager.repository.UserRepository

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun login(username: String, password: String) = repository.login(username, password)
}