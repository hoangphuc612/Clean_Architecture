package com.example.data.di

import android.content.Context
import com.example.data.repository.source.local.sqlite.database.AppDatabase
import com.example.data.repository.source.local.sqlite.database.DatabaseBuilder
import org.koin.dsl.module

val storageModule = module {

    fun buildRoomDB(context: Context) = DatabaseBuilder().buildRoomDB(context)

    fun provideRepoDao(appDatabase: AppDatabase) = appDatabase.repoDao

    single { buildRoomDB(get()) }

    single { provideRepoDao(get()) }
}
