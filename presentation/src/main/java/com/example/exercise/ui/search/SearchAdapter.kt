package com.example.exercise.ui.search

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.exercise.ui.search.search_repo.SearchRepoFragment
import com.example.exercise.ui.search.search_user.SearchUserFragment

class SearchAdapter(
    fragment: Fragment,
    private var fragments: List<Fragment> = listOf()
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun search(keyword: String) {
        fragments.forEach {
            when (it) {
                is SearchUserFragment -> it.searchUser(keyword)
                is SearchRepoFragment -> it.searchRepo(keyword)
            }
        }
    }

    fun addFragments(fragments: List<Fragment>) {
        this.fragments = fragments
    }
}
