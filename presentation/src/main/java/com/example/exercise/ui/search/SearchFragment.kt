package com.example.exercise.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise.databinding.FragmentSearchBinding
import com.example.exercise.ui.search.search_repo.SearchRepoFragment
import com.example.exercise.ui.search.search_user.SearchUserFragment
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : Fragment() {

    private lateinit var viewBinding: FragmentSearchBinding
    private val searchAdapter by lazy { SearchAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val listFragment =
            listOf(SearchUserFragment.newInstance(), SearchRepoFragment.newInstance())
        viewBinding.run {
            viewPagerSearch.adapter = searchAdapter.apply {
                addFragments(listFragment)
            }
            TabLayoutMediator(this.tabLayout, viewPagerSearch) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = USER
                    }
                    1 -> {
                        tab.text = REPO
                    }
                }
            }.attach()
        }
    }

    companion object {
        private const val USER = "User"
        private const val REPO = "Repo"
        fun newInstance() = SearchFragment()
    }
}
