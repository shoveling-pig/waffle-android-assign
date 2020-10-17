package com.example.moviedb.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviedb.R
import com.example.moviedb.databinding.ActivityDiscoveryBinding
import com.example.moviedb.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_discovery.*
import org.koin.android.viewmodel.ext.android.viewModel

class DiscoverActivity : AppCompatActivity() {
    private val discoverViewModel: DiscoverViewModel by viewModel()
    private lateinit var binding: ActivityDiscoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_discovery
        )

        binding.run {
            lifecycleOwner = this@DiscoverActivity
            viewModel = discoverViewModel
            adapter = MovieListAdapter {
                val intent = Intent(this@DiscoverActivity, DetailActivity::class.java)
                intent.putExtra("movie_id", it.id)
                startActivity(intent)
            }
        }

        val layoutManager = GridLayoutManager(this, 2)
        discover_movie_list.layoutManager = layoutManager
    }
}