package com.example.exercise.ui.search.search_repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Repo
import com.example.domain.usecases.SearchRepoUseCase
import com.example.domain.usecases.base.SingleObserver
import com.example.exercise.base.BaseViewModel
import com.example.exercise.mapper.PresentationMapper
import com.example.exercise.mapper.RepoModelMapper
import com.example.exercise.model.RepoModel
import com.example.exercise.state.Resource
import com.example.exercise.ui.search.search_repo.adapter.RepoItem

class SearchRepoViewModel(
    private val searchRepoUseCase: SearchRepoUseCase,
    private val mapper: RepoModelMapper
) : BaseViewModel() {

    private val _searchRepoLiveData = MutableLiveData<Resource<List<RepoItem>>>()
    val searchRepoLiveData: LiveData<Resource<List<RepoItem>>>
        get() = _searchRepoLiveData

    fun searchRepo(keyword: String, page: Int = 1) {
        _searchRepoLiveData.postValue(Resource.loading(null))
        searchRepoUseCase.execute(
            SearchRepoUseCase.Params(keyword, page),
            object : SingleObserver<List<Repo>>() {

                override fun onSuccess(data: List<Repo>) {
                    val repos = data.map(mapper::toModel)
                    _searchRepoLiveData.postValue(Resource.success(repos.map { RepoItem(it) }))
                }

                override fun onError(throwable: Throwable) {
                    _searchRepoLiveData.postValue(Resource.error(null, throwable.toString()))
                }
            })
    }
}
