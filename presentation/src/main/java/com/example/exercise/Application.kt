package com.example.exercise

import android.app.Application
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.data.di.storageModule
import com.example.exercise.di.appModule
import com.example.exercise.di.mapperModule
import com.example.exercise.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                appModule,
                networkModule,
                storageModule,
                repositoryModule,
                mapperModule,
                viewModelModule,
            )
        }
    }
}
