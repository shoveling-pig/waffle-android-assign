package com.example.moviedb.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.moviedb.R
import com.example.moviedb.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding
    private var movieId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra("movie_id")) {
            movieId = intent.getLongExtra("movie_id", 0)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.run {
            lifecycleOwner = this@DetailActivity
            viewModel = detailViewModel
        }

        detailViewModel?.setMovie(movieId)
    }
}
