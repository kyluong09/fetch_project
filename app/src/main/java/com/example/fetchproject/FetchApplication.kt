package com.example.fetchproject

import android.app.Application
import com.example.fetchproject.dependencyInjection.koinModule.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FetchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }


    private fun setupKoin(){
        startKoin {
            androidContext(this@FetchApplication)
            modules(koinModule)
        }
    }
}