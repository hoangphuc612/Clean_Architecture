package com.example.exercise.di

import com.example.domain.usecases.*
import com.example.exercise.ui.search.search_repo.SearchRepoViewModel
import com.example.exercise.ui.search.search_user.SearchUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SearchRepoViewModel(
            SearchRepoUseCase(get(), get(), get()),
            SaveRepoUseCase(get(), get(), get()),
            DeleteRepoUseCase(get(), get(), get()),
            CheckFavoriteUseCase(get(), get(), get()),
            mapper = get()
        )
    }

    viewModel {
        SearchUserViewModel(
            SearchUserUseCase(get(), get(), get()),
            mapper = get()
        )
    }
}
