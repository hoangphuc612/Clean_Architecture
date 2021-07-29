package com.example.data.repository.source.local.sqlite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepoEntity(
    @PrimaryKey @ColumnInfo(name = REPO_ID) val id: Int,
    @ColumnInfo(name = REPO_NAME) val name: String,
    @ColumnInfo(name = REPO_DESCRIPTION) val description: String,
    @ColumnInfo(name = REPO_IS_FAVORITE) val isFavorite: Boolean,
) {

    companion object {
        const val TABLE_NAME = "repo"

        const val REPO_ID = "id"
        const val REPO_NAME = "name"
        const val REPO_DESCRIPTION = "description"
        const val REPO_IS_FAVORITE = "is_favorite"
    }
}
