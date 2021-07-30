package com.example.exercise.ui.search.search_repo

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.exercise.R
import com.example.exercise.base.BaseFragment
import com.example.exercise.databinding.FragmentSearchRepoBinding
import com.example.exercise.state.Status
import com.example.exercise.ui.search.search_repo.adapter.RepoAdapter
import com.example.exercise.ui.search.search_repo.adapter.RepoItem
import com.example.exercise.util.Logcat
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchRepoFragment : BaseFragment<FragmentSearchRepoBinding, SearchRepoViewModel>() {

    private var repoItem: RepoItem? = null

    private val repoAdapter by lazy {
        RepoAdapter { repoItem ->
            this.repoItem = repoItem
            viewModel.checkFavorite(repoItem.repoModel.id)
        }
    }
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
        viewBinding.apply {
            recyclerViewRepo.adapter = repoAdapter
        }
    }

    private fun setupObserver() = with(viewModel) {
        searchRepoLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    repoAdapter.submitList(it.data?.toMutableList())
                }
                Status.ERROR -> {
                    Logcat.checkLog(it.message.toString())
                }
            }
        }
        isFavoriteLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    it.data?.let { isFavorite ->
                        if (!isFavorite) repoItem?.let { repoItemData ->
                            repoItemData.repoModel.isFavorite = true
                            viewModel.saveRepo(repoItemData)
                        }
                        else repoItem?.let { repoItemData ->
                            repoItemData.repoModel.isFavorite = false
                            viewModel.deleteRepo(repoItemData)
                        }
                    }
                }
                Status.ERROR -> {
                    Logcat.checkLog(it.message.toString())
                }
            }
        }
        saveRepoLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.ERROR -> {
                    Logcat.checkLog(it.message.toString())
                }
            }
        }
    }

    private fun handleEvent() {
        viewBinding.apply {
            searchViewRepo.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let { viewModel.searchRepo(query) }
                    searchViewRepo.clearFocus()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean = false
            })
        }
    }

    companion object {
        fun newInstance() = SearchRepoFragment()
    }
}
