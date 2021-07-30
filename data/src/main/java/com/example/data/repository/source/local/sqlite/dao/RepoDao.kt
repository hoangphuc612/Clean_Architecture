package com.example.data.repository.source.local.sqlite.dao

import androidx.room.*
import com.example.data.repository.source.local.sqlite.entity.RepoEntity

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(repo: RepoEntity): Long

    @Delete
    fun delete(repo: RepoEntity): Int

    @Query("SELECT EXISTS(SELECT * FROM ${RepoEntity.REPO_TABLE} WHERE id = :repoId)")
    fun checkFavorite(repoId: Int): Boolean
}
