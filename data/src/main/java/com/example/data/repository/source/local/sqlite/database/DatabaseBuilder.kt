package com.example.data.repository.source.local.sqlite.database

import android.content.Context
import androidx.room.Room
import com.example.data.repository.source.local.sqlite.entity.RepoEntity

class DatabaseBuilder {

    fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            RepoEntity.REPO_TABLE
        ).build()
}
