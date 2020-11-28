package com.example.seminarmanager.ui.detailseminar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.seminarmanager.R
import com.example.seminarmanager.SeminarManagerApplication
import com.example.seminarmanager.databinding.ActivityDetailSeminarBinding
import com.example.seminarmanager.room.PartSeminarIdViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailSeminarActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_SEMINAR_ID = "extra_seminar_id"
        fun intentWithSeminarId(context: Context, seminarId: Long)
            = Intent(context, DetailSeminarActivity::class.java)
            .apply{ putExtra(EXTRA_SEMINAR_ID, seminarId) }
    }

    private val detailSeminarViewModel: DetailSeminarViewModel by viewModel()
    private val partSeminarIdViewModel: PartSeminarIdViewModel by viewModel()
    private val binding: ActivityDetailSeminarBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_detail_seminar) }
    private var seminarId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra(EXTRA_SEMINAR_ID)) {
            seminarId = intent.getLongExtra(EXTRA_SEMINAR_ID, -1L)
        }

        binding.run {
            lifecycleOwner = this@DetailSeminarActivity
            viewModel = detailSeminarViewModel
            instAdapter = InstructorListAdapter()
            partAdapter = ParticipantListAdapter()
        }
        binding.joinBtn.setOnClickListener {
            join()
        }

        detailSeminarViewModel.setSeminar(seminarId)
    }

    private fun join() {
        detailSeminarViewModel.joinSeminar(seminarId)

        val role = SeminarManagerApplication.prefs.getString("user_role_key", "none")
        if (role == "participant") {
            partSeminarIdViewModel.insertId(seminarId)
        }
    }
}