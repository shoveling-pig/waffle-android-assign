package com.example.seminarmanager.di

import com.example.seminarmanager.repository.SeminarRepository
import com.example.seminarmanager.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        SeminarRepository(get())
    }
    single {
        UserRepository(get())
    }
}