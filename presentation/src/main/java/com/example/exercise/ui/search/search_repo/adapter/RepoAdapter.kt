package com.example.exercise.ui.search.search_repo.adapter

import android.view.ViewGroup
import com.example.exercise.R
import com.example.exercise.base.recyclerview.BaseDiffUtilItemCallback
import com.example.exercise.base.recyclerview.BaseRecyclerAdapter
import com.example.exercise.base.recyclerview.BaseViewHolder
import com.example.exercise.databinding.ItemSearchRepoBinding

val diffUtil = object : BaseDiffUtilItemCallback<RepoItem>() {

    override fun areItemsTheSame(oldItem: RepoItem, newItem: RepoItem): Boolean =
        oldItem == newItem
}

class RepoAdapter :
    BaseRecyclerAdapter<RepoItem, ItemSearchRepoBinding, RepoAdapter.RepoViewHolder>(diffUtil) {

    override fun getItemLayoutResource(viewType: Int) = R.layout.item_search_repo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepoViewHolder(getViewHolderDataBinding(parent, viewType) as ItemSearchRepoBinding)

    class RepoViewHolder(binding: ItemSearchRepoBinding) :
        BaseViewHolder<RepoItem, ItemSearchRepoBinding>(binding) {

        override fun bind(itemData: RepoItem) {
            super.bind(itemData)
            binding.repo = itemData.repoModel
        }
    }
}
