package com.sanggggg.tictactoe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.tictactoe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var ticTacToeViewModel: TicTacToeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ticTacToeViewModel = ViewModelProvider(this).get(TicTacToeViewModel::class.java)

        binding.apply {
            viewModel = ticTacToeViewModel
            lifecycleOwner = this@MainActivity
        }

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)

        button_restart.setOnClickListener {
            ticTacToeViewModel.restart()
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.button0 -> ticTacToeViewModel.clickCell(0)
            R.id.button1 -> ticTacToeViewModel.clickCell(1)
            R.id.button2 -> ticTacToeViewModel.clickCell(2)
            R.id.button3 -> ticTacToeViewModel.clickCell(3)
            R.id.button4 -> ticTacToeViewModel.clickCell(4)
            R.id.button5 -> ticTacToeViewModel.clickCell(5)
            R.id.button6 -> ticTacToeViewModel.clickCell(6)
            R.id.button7 -> ticTacToeViewModel.clickCell(7)
            R.id.button8 -> ticTacToeViewModel.clickCell(8)
        }

    }
}