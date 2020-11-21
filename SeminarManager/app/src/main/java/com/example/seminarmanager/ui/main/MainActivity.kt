package com.example.seminarmanager.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.seminarmanager.R
import com.example.seminarmanager.ui.login.LoginViewModel
import com.example.seminarmanager.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    private val mainViewModel: MainViewModel by viewModel()
    private val seminarFragment by lazy { SeminarFragment() }
    private val userFragment by lazy { UserFragment() }
    private val fragments: List<Fragment> = listOf(seminarFragment, userFragment)

    private val pagerAdapter: MainViewPagerAdapter by lazy {
        MainViewPagerAdapter(this, fragments)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
        initNavigationBar()
    }

    private fun initViewPager() {
        main_view_pager.run {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    val navigation = when(position) {
                        0 -> R.id.menu_seminar
                        1 -> R.id.menu_user
                        else -> R.id.menu_seminar
                    }

                    if (main_navigation.selectedItemId != navigation) {
                        main_navigation.selectedItemId = navigation
                    }
                }
            })
        }
    }

    private fun initNavigationBar() {
        main_navigation.run {
            setOnNavigationItemSelectedListener {
                val page = when(it.itemId) {
                    R.id.menu_seminar -> 0
                    R.id.menu_user -> 1
                    else -> 0
                }

                if (page != main_view_pager.currentItem) {
                    main_view_pager.currentItem = page
                }
                true
            }
            selectedItemId = R.id.menu_seminar
        }
    }
}