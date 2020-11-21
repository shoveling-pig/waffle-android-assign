package com.example.seminarmanager

import android.app.Application
import com.example.seminarmanager.di.networkModule
import com.example.seminarmanager.di.repositoryModule
import com.example.seminarmanager.di.viewModelModule
import com.example.seminarmanager.utils.PreferenceUtil
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SeminarManagerApplication : Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceUtil(applicationContext)

        startKoin {
            androidContext(this@SeminarManagerApplication)
            modules(listOf(networkModule, viewModelModule, repositoryModule))
        }
    }

}