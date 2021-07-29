package com.example.data.repository.source.remote.api

import com.example.data.repository.source.remote.api.response.RepoResponse
import com.example.data.repository.source.remote.api.response.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users?")
    fun searchUsers(
        @Query("q") userName: String,
        @Query("page") page: Int
    ): Single<UserResponse>

    @GET("search/repositories?")
    fun searchRepo(
        @Query("q") repo: String,
        @Query("page") page: Int
    ): Single<RepoResponse>
}
