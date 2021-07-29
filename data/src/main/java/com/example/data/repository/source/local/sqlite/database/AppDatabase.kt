package com.example.data.repository.source.local.sqlite.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.repository.source.local.sqlite.dao.RepoDao
import com.example.data.repository.source.local.sqlite.entity.RepoEntity

@Database(entities = [RepoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract val repoDao: RepoDao
}
