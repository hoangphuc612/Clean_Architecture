package com.example.exercise.ui.favorite

import android.os.Bundle
import android.view.View
import com.example.exercise.R
import com.example.exercise.base.BaseFragment
import com.example.exercise.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override val viewModel: FavoriteViewModel by viewModel()
    override val layoutId: Int
        get() = R.layout.fragment_favorite

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
