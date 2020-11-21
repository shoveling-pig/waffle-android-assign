package com.example.seminarmanager.repository

import android.util.Log
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.api.UserService
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepository(private val service: UserService) {
    fun login(username: String, password:String): Boolean {
        var token:String? = null
        var role:String? = null

        val response = service.login(username, password)
        response.subscribeOn(Schedulers.io())
                .subscribe { user ->
                    token = user.token
                    if(user.participant==null) {
                        role = "instructor"
                    } else {
                        role = "participant"
                    }
                }

        if (token != null) {
            SeminarManagerApplication.prefs.setString("user_token_key", token!!)
            SeminarManagerApplication.prefs.setString("user_username_key", username!!)
            SeminarManagerApplication.prefs.setString("user_role_key", role!!)
            return true
        }
        return false
    }

    fun signUp(username:String, password:String, email:String, firstname:String, lastname:String, role:String, company:String, year:String, university:String, accepted:String): Boolean {
        var token:String? = null

        val response = service.signUp(username, password, email, firstname, lastname, role, company, year, university, accepted)
        response.subscribeOn(Schedulers.io())
            .subscribe { user ->
                token = user.token
            }

        if (token != null) {
            SeminarManagerApplication.prefs.setString("user_token_key", token!!)
            SeminarManagerApplication.prefs.setString("user_username_key", username!!)
            SeminarManagerApplication.prefs.setString("user_role_key", role!!)
            return true
        }
        return false
    }

    fun getUserInfo() = service.getUserInfo()

    fun editUserInfo(username: String, firstname: String, lastname: String): Boolean {
        var isSuccess = false;
        val response = service.editUserInfo(username, firstname, lastname)
        response.subscribeOn(Schedulers.io())
            .subscribe { user ->
                if (username == user.username) {
                    isSuccess = true
                }
            }
        return isSuccess
    }
}