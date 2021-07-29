package com.example.exercise.ui.search.search_user.adapter

import android.view.ViewGroup
import com.example.exercise.R
import com.example.exercise.base.recyclerview.BaseDiffUtilItemCallback
import com.example.exercise.base.recyclerview.BaseRecyclerAdapter
import com.example.exercise.base.recyclerview.BaseViewHolder
import com.example.exercise.databinding.ItemSearchUserBinding

val diffUtil = object : BaseDiffUtilItemCallback<UserItem>() {

    override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean =
        oldItem == newItem
}

class UserAdapter :
    BaseRecyclerAdapter<UserItem, ItemSearchUserBinding, UserAdapter.UserViewHolder>(diffUtil) {

    override fun getItemLayoutResource(viewType: Int) = R.layout.item_search_user

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(getViewHolderDataBinding(parent, viewType) as ItemSearchUserBinding)

    class UserViewHolder(binding: ItemSearchUserBinding) :
        BaseViewHolder<UserItem, ItemSearchUserBinding>(binding) {

        override fun bind(itemData: UserItem) {
            super.bind(itemData)
            binding.user = itemData.userModel
        }
    }
}
