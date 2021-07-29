package com.example.exercise.ui.search.search_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Repo
import com.example.domain.entity.User
import com.example.domain.usecases.SearchRepoUseCase
import com.example.domain.usecases.SearchUserUseCase
import com.example.domain.usecases.base.SingleObserver
import com.example.exercise.base.BaseViewModel
import com.example.exercise.mapper.PresentationMapper
import com.example.exercise.mapper.UserModelMapper
import com.example.exercise.model.UserModel
import com.example.exercise.state.Resource
import com.example.exercise.ui.search.search_user.adapter.UserItem

class SearchUserViewModel(
    private val searchUserUseCase: SearchUserUseCase,
    private val mapper: UserModelMapper
) : BaseViewModel() {

    private val _searchUserLiveData = MutableLiveData<Resource<List<UserItem>>>()
    val searchUserLiveData: LiveData<Resource<List<UserItem>>>
        get() = _searchUserLiveData

    fun searchUser(keyword: String, page: Int = 1) {
        _searchUserLiveData.postValue(Resource.loading(null))
        searchUserUseCase.execute(
            SearchUserUseCase.Params(keyword, page),
            object : SingleObserver<List<User>>() {

                override fun onSuccess(data: List<User>) {
                    val users = data.map(mapper::toModel)
                    _searchUserLiveData.postValue(Resource.success(users.map { UserItem(it) }))
                }

                override fun onError(throwable: Throwable) {
                    _searchUserLiveData.postValue(Resource.error(null, throwable.toString()))
                }
            })
    }
}
