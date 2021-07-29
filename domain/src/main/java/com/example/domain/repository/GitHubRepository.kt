package com.example.domain.repository

import com.example.domain.entity.Repo
import com.example.domain.entity.User
import io.reactivex.rxjava3.core.Single

interface GitHubRepository {

    fun searchUser(userName: String, page: Int): Single<List<User>>

    fun searchRepo(repoName: String, page: Int): Single<List<Repo>>
}
