package com.example.moviedb.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moviedb.R
import com.example.moviedb.databinding.ActivityDiscoveryBinding
import com.example.moviedb.ui.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class DiscoverActivity : AppCompatActivity() {
    private val viewModel: DiscoverViewModel by viewModel()
    private lateinit var binding: ActivityDiscoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_discovery
        )

        binding.run {
            lifecycleOwner = this@DiscoverActivity
            viewModel = viewModel
            adapter = MovieListAdapter {
                val intent = Intent(this@DiscoverActivity, DetailActivity::class.java)
                intent.putExtra("movie_id", it.id)
                startActivity(intent)
            }
        }
    }
}