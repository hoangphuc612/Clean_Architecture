package com.example.exercise.ui.search.search_user

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.exercise.R
import com.example.exercise.base.BaseFragment
import com.example.exercise.databinding.FragmentSearchUserBinding
import com.example.exercise.state.Status
import com.example.exercise.ui.search.search_user.adapter.UserAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchUserFragment : BaseFragment<FragmentSearchUserBinding, SearchUserViewModel>() {

    private val userAdapter by lazy { UserAdapter() }
    override val viewModel: SearchUserViewModel by viewModel()
    override val layoutId: Int
        get() = R.layout.fragment_search_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.searchUserLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    userAdapter.submitList(it.data?.toMutableList())
                }
                Status.ERROR -> {
                    Log.d("TAG", it.message.toString())
                    Log.d("SearchUser", it.data.toString())
                }
            }
        }
    }

    private fun initView() {
        viewBinding.recyclerViewUser.adapter = userAdapter
    }

    fun searchUser(keyword: String) {
        viewModel.searchUser(keyword, 1)
    }

    companion object {
        fun newInstance() = SearchUserFragment()
    }
}
