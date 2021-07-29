package com.example.exercise.ui.search.search_repo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.exercise.R
import com.example.exercise.base.BaseFragment
import com.example.exercise.databinding.FragmentSearchRepoBinding
import com.example.exercise.state.Status
import com.example.exercise.ui.search.search_repo.adapter.RepoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchRepoFragment : BaseFragment<FragmentSearchRepoBinding, SearchRepoViewModel>() {

    private val repoAdapter by lazy { RepoAdapter() }
    override val viewModel: SearchRepoViewModel by viewModel()
    override val layoutId: Int
        get() = R.layout.fragment_search_repo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObserver()
        handleEvent()
    }

    private fun initView() {
        viewBinding.recyclerViewRepo.adapter = repoAdapter
    }

    private fun setupObserver() {
        viewModel.searchRepoLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    repoAdapter.submitList(it.data?.toMutableList())
                }
                Status.ERROR -> {

                }
            }
        }
    }

    private fun handleEvent() {

    }

    fun searchRepo(keyword: String) {
        viewModel.searchRepo(keyword)
    }

    companion object {
        fun newInstance() = SearchRepoFragment()
    }
}
