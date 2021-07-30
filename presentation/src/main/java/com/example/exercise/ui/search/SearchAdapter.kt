package com.example.exercise.ui.search

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchAdapter(
    fragment: Fragment,
    private var fragments: List<Fragment> = listOf()
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragments(fragments: List<Fragment>) {
        this.fragments = fragments
    }
}
