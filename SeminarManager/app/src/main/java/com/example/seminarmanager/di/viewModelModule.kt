package com.example.seminarmanager.di

import com.example.seminarmanager.repository.UserRepository
import com.example.seminarmanager.room.PartSeminarIdViewModel
import com.example.seminarmanager.ui.createseminar.CreateSeminarViewModel
import com.example.seminarmanager.ui.detailseminar.DetailSeminarViewModel
import com.example.seminarmanager.ui.login.LoginViewModel
import com.example.seminarmanager.ui.main.MainViewModel
import com.example.seminarmanager.ui.signup.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }

    viewModel {
        CreateSeminarViewModel(get())
    }
    viewModel {
        DetailSeminarViewModel(get())
    }
    viewModel {
        PartSeminarIdViewModel(get())
    }
}