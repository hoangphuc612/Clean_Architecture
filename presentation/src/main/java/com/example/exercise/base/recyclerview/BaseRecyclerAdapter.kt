package com.example.exercise.base.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T : RecyclerViewItem, VB : ViewDataBinding, VH : BaseViewHolder<T, VB>>(
    diffUtilCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffUtilCallback) {

    @LayoutRes
    abstract fun getItemLayoutResource(viewType: Int): Int

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    protected fun getViewHolderDataBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getItemLayoutResource(viewType),
            parent,
            false
        )

    protected fun inflateView(parent: ViewGroup, @LayoutRes layoutResId: Int): View =
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
}
