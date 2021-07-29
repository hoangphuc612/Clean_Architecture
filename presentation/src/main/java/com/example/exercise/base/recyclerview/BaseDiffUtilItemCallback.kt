package com.example.exercise.base.recyclerview

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtilItemCallback<T : RecyclerViewItem> : DiffUtil.ItemCallback<T>() {

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}
