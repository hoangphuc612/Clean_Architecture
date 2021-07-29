package com.example.data.repository.source.remote

import com.example.data.repository.source.remote.api.ApiService
import com.example.data.repository.source.remote.api.response.RepoResponse
import com.example.data.repository.source.remote.api.response.UserResponse
import io.reactivex.rxjava3.core.Single

class GithubRemoteDataSource(private val apiService: ApiService) {

    fun searchUser(keyword: String, page: Int): Single<UserResponse> =
        apiService.searchUsers(keyword, page)

    fun searchRepo(keyword: String, page: Int): Single<RepoResponse> =
        apiService.searchRepo(keyword, page)
}
