package com.example.seminarmanager.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.seminarmanager.R
import com.example.seminarmanager.databinding.FragmentSeminarBinding
import com.example.seminarmanager.databinding.FragmentUserBinding
import com.example.seminarmanager.ui.detailseminar.DetailSeminarActivity
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class UserFragment : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seminar, container, false)
        binding.run {
            lifecycleOwner = this@UserFragment
            viewModel = mainViewModel
            instSeminarAdapter = InstSeminarAdapter {
                startActivity(DetailSeminarActivity.intentWithSeminarId(context!!, it.id))
            }
            partSeminarAdapter = PartSeminarAdapter {
                startActivity(DetailSeminarActivity.intentWithSeminarId(context!!, it.id))
            }
        }
        binding.editBtn.setOnClickListener {
            editUserInfo(
                user_frag_username.text.toString(),
                user_frag_firstname.text.toString(),
                user_frag_lastname.text.toString()
            )
        }

        mainViewModel.getUserInfo()
        return binding.root
    }

    private fun editUserInfo(username: String, firstname: String, lastname: String) {
        val isSuccess = mainViewModel.editUserInfo(username, firstname, lastname)

        if (isSuccess) {
            Toast.makeText(context, "수정이 완료되었습니.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }
    }

}