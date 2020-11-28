package com.example.seminarmanager.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.seminarmanager.R
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.databinding.FragmentSeminarBinding
import com.example.seminarmanager.room.PartSeminarIdViewModel
import com.example.seminarmanager.ui.createseminar.CreateSeminarActivity
import org.koin.android.viewmodel.ext.android.sharedViewModel


class SeminarFragment : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()
    private val partViewModel: PartSeminarIdViewModel by sharedViewModel()
    private lateinit var binding: FragmentSeminarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seminar, container, false)
        binding.run {
            lifecycleOwner = this@SeminarFragment
            viewModel = mainViewModel
            adapter = SeminarAdapter(partViewModel)
        }

        mainViewModel.setSeminarList()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.actionbar_menu, menu)

        checkUserRole(menu)
        Log.d("WAFFLE_DEBUG", "onCreateOptionsMenu()")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item?.itemId) {
            R.id.plusBtn -> {
                startActivity(CreateSeminarActivity.intent(context!!))
                true
            }
            else -> {
                false
            }
    }

    private fun checkUserRole(menu: Menu) {
        val role = SeminarManagerApplication.prefs.getString("user_role_key", "none")
        if (role == "instructor") {
            menu.findItem(R.id.plusBtn).isVisible = true
        }
        Log.d("WAFFLE_DEBUG", "role : $role")
    }

}
