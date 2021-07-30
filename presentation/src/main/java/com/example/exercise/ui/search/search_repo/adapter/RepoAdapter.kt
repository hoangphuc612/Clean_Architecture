package com.example.exercise.ui.search.search_repo.adapter

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.exercise.R
import com.example.exercise.base.recyclerview.BaseDiffUtilItemCallback
import com.example.exercise.base.recyclerview.BaseRecyclerAdapter
import com.example.exercise.base.recyclerview.BaseViewHolder
import com.example.exercise.databinding.ItemSearchRepoBinding

val diffUtil = object : BaseDiffUtilItemCallback<RepoItem>() {

    override fun areItemsTheSame(oldItem: RepoItem, newItem: RepoItem): Boolean =
        oldItem == newItem
}

class RepoAdapter(
    private val onFavoriteClick: (RepoItem) -> Unit
) : BaseRecyclerAdapter<RepoItem, ItemSearchRepoBinding, RepoAdapter.RepoViewHolder>(diffUtil) {

    override fun getItemLayoutResource(viewType: Int) = R.layout.item_search_repo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepoViewHolder(
            getViewHolderDataBinding(parent, viewType) as ItemSearchRepoBinding,
            onFavoriteClick
        )


    class RepoViewHolder(
        binding: ItemSearchRepoBinding,
        private val onFavoriteClick: (RepoItem) -> Unit
    ) : BaseViewHolder<RepoItem, ItemSearchRepoBinding>(binding) {

        override fun bind(itemData: RepoItem) {
            super.bind(itemData)
            binding.run {
                repo = itemData
                imageFavoriteRepo.setOnClickListener { onFavoriteClick(itemData) }
                imageFavoriteRepo.setImageDrawable(
                    ContextCompat.getDrawable(
                        root.context,
                        if (itemData.repoModel.isFavorite) R.drawable.heart else R.drawable.heart_outline
                    )
                )
            }
        }
    }
}
