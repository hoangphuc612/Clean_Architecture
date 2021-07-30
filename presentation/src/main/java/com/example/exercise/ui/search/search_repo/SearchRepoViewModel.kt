package com.example.exercise.ui.search.search_repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Repo
import com.example.domain.usecases.*
import com.example.domain.usecases.base.SingleObserver
import com.example.exercise.base.BaseViewModel
import com.example.exercise.mapper.RepoModelMapper
import com.example.exercise.state.Resource
import com.example.exercise.ui.search.search_repo.adapter.RepoItem

class SearchRepoViewModel(
    private val searchRepoUseCase: SearchRepoUseCase,
    private val saveRepoUseCase: SaveRepoUseCase,
    private val deleteRepoUseCase: DeleteRepoUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase,
    private val mapper: RepoModelMapper
) : BaseViewModel() {

    private val _searchRepoLiveData = MutableLiveData<Resource<List<RepoItem>>>()
    val searchRepoLiveData: LiveData<Resource<List<RepoItem>>>
        get() = _searchRepoLiveData

    private val _isFavoriteLiveData = MutableLiveData<Resource<Boolean>>()
    val isFavoriteLiveData: LiveData<Resource<Boolean>>
        get() = _isFavoriteLiveData

    private val _saveRepoLiveData = MutableLiveData<Resource<Long>>()
    val saveRepoLiveData: LiveData<Resource<Long>>
        get() = _saveRepoLiveData

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

    fun saveRepo(repo: RepoItem) {
        saveRepoUseCase.execute(
            mapper.toDomain(repo.repoModel), object : SingleObserver<Long>() {

                override fun onSuccess(data: Long) {
                    _saveRepoLiveData.postValue(Resource.success(data))
                }

                override fun onError(throwable: Throwable) {
                    _isFavoriteLiveData.postValue(Resource.error(null, throwable.toString()))
                }
            }
        )
    }

    fun deleteRepo(repo: RepoItem) {
        deleteRepoUseCase.execute(
            mapper.toDomain(repo.repoModel), object : SingleObserver<Int>() {

                override fun onSuccess(data: Int) {

                }

                override fun onError(throwable: Throwable) {

                }
            }
        )
    }

    fun checkFavorite(repoId: Int) {
        checkFavoriteUseCase.execute(
            repoId, object : SingleObserver<Boolean>() {

                override fun onSuccess(data: Boolean) {
                    if (data) _isFavoriteLiveData.postValue(
                        Resource.success(true)
                    )
                    else _isFavoriteLiveData.postValue(Resource.success(false))
                }

                override fun onError(throwable: Throwable) {
                    _isFavoriteLiveData.postValue(Resource.error(null, throwable.toString()))
                }
            }
        )
    }
}
