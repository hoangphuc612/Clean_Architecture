package com.example.data.repository.source.local.sqlite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.repository.source.local.sqlite.entity.RepoEntity

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(repo: RepoEntity): Long
}
