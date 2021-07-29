package com.example.exercise.ui.search.search_repo.adapter

import com.example.exercise.base.recyclerview.RecyclerViewItem
import com.example.exercise.base.recyclerview.TYPE_ITEM
import com.example.exercise.model.RepoModel

data class RepoItem(
    val repoModel: RepoModel,
    override var type: Int = TYPE_ITEM
) : RecyclerViewItem
