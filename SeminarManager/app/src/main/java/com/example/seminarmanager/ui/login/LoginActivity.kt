package com.example.seminarmanager.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.seminarmanager.R
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.api.Seminar
import com.example.seminarmanager.databinding.ActivityLoginBinding
import com.example.seminarmanager.ui.main.MainActivity
import com.example.seminarmanager.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModel()
    private val binding: ActivityLoginBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_login) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkUserToken()

        binding.run {
            lifecycleOwner = this@LoginActivity
        }
        binding.loginBtn.setOnClickListener {
            login(login_username.text.toString(), login_password.text.toString())
        }
        binding.signupBtn.setOnClickListener {
            startActivity(SignUpActivity.intent(this@LoginActivity))
        }
    }

    private fun checkUserToken() {
        val userToken = SeminarManagerApplication.prefs.getString("user_token_key", "none")
        if (userToken != "none") {
            startActivity(MainActivity.intent(this@LoginActivity))
        }
    }

    private fun login(username:String, password:String) {
        val isSuccess = loginViewModel.login(username, password)

        if (isSuccess) {
            startActivity(MainActivity.intent(this@LoginActivity))
        } else {
            Toast.makeText(this@LoginActivity, "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }
    }

}