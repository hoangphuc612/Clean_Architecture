package com.example.exercise.ui.search.search_user.adapter

import com.example.exercise.base.recyclerview.RecyclerViewItem
import com.example.exercise.base.recyclerview.TYPE_ITEM
import com.example.exercise.model.UserModel

data class UserItem(
    val userModel: UserModel,
    override var type: Int = TYPE_ITEM
): RecyclerViewItem
