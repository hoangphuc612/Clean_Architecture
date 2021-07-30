package com.example.data.repository.source.local.sqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.repository.source.local.sqlite.entity.RepoEntity.Companion.REPO_TABLE

@Entity(tableName = REPO_TABLE)
data class RepoEntity(
    @PrimaryKey @ColumnInfo(name = REPO_ID) val id: Int,
    @ColumnInfo(name = REPO_NAME) val name: String,
    @ColumnInfo(name = REPO_DESCRIPTION) val description: String?,
) {

    companion object {
        const val REPO_TABLE = "repo"

        const val REPO_ID = "id"
        const val REPO_NAME = "name"
        const val REPO_DESCRIPTION = "description"
    }
}
