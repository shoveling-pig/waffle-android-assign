package com.example.seminarmanager.ui.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.seminarmanager.R
import com.example.seminarmanager.databinding.ActivitySignUpBinding
import com.example.seminarmanager.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context): Intent = Intent(context, SignUpActivity::class.java)
    }

    private val signUpViewModel: SignUpViewModel by viewModel()
    private val binding: ActivitySignUpBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_sign_up) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            lifecycleOwner = this@SignUpActivity
        }
        binding.confirmBtn.setOnClickListener {
            signUp(
                signup_username.text.toString(),
                signup_password.text.toString(),
                signup_email.text.toString(),
                signup_firstname.text.toString(),
                signup_lastname.text.toString(),
                signup_role.text.toString(),
                signup_company.text.toString(),
                signup_year.text.toString(),
                signup_university.text.toString(),
                signup_accepted.text.toString()
            )
        }
    }

    private fun signUp(username:String, password:String, email:String, firstname:String, lastname:String,
                role:String, company:String, year:String, university:String, accepted:String) {
        Log.d("WAFFLE_DEBUG", "SignUpActivity.signUp()")
        val isSuccess = signUpViewModel.signUp(username, password, email, firstname, lastname, role, company, year, university, accepted)

        if (isSuccess) {
            startActivity(MainActivity.intent(this))
        } else {
            Toast.makeText(this@SignUpActivity, "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }
    }
}