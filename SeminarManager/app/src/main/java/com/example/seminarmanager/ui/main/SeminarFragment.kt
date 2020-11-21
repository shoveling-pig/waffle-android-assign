package com.example.seminarmanager.ui.main

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.seminarmanager.R
import com.example.seminarmanager.databinding.FragmentSeminarBinding
import com.example.seminarmanager.ui.createseminar.CreateSeminarActivity
import org.koin.android.viewmodel.ext.android.sharedViewModel


class SeminarFragment : Fragment() {
    private val mainViewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentSeminarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seminar, container, false)
        binding.run {
            lifecycleOwner = this@SeminarFragment
            viewModel = mainViewModel
            adapter = SeminarAdapter()
        }

        mainViewModel.setSeminarList()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actionbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
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

}
