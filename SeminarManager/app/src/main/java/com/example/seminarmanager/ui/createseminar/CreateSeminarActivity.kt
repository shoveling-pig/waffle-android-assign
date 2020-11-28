package com.example.seminarmanager.ui.createseminar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.seminarmanager.R
import com.example.seminarmanager.databinding.ActivityCreateSeminarBinding
import com.example.seminarmanager.databinding.ActivityLoginBinding
import com.example.seminarmanager.ui.detailseminar.DetailSeminarActivity
import com.example.seminarmanager.ui.login.LoginViewModel
import com.example.seminarmanager.ui.main.MainActivity
import com.example.seminarmanager.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_create_seminar.*
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreateSeminarActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context) = Intent(context, CreateSeminarActivity::class.java)
    }

    private val createSeminarViewModel: CreateSeminarViewModel by viewModel()
    private val binding: ActivityCreateSeminarBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_create_seminar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            lifecycleOwner = this@CreateSeminarActivity
        }
        binding.createBtn.setOnClickListener {
            createSeminar(
                create_seminar_name.text.toString(),
                create_seminar_capacity.text.toString(),
                create_seminar_count.text.toString(),
                create_seminar_time.text.toString(),
                create_seminar_online.text.toString()
            )
        }
    }

    private fun createSeminar(name:String, capacity:String, count:String, time:String, online:String) {
        val seminarId = createSeminarViewModel.createSeminar(name, capacity, count, time, online)

        if (seminarId != -1L) {
            startActivity(DetailSeminarActivity.intentWithSeminarId(this@CreateSeminarActivity, seminarId))
        } else {
            Toast.makeText(this@CreateSeminarActivity, "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }
    }
}