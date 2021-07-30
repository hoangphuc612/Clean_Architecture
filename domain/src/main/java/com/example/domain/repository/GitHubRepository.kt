package com.example.domain.repository

import com.example.domain.entity.Repo
import com.example.domain.entity.User
import io.reactivex.rxjava3.core.Single

interface GitHubRepository {

    fun searchUser(userName: String, page: Int): Single<List<User>>

    fun searchRepo(repoName: String, page: Int): Single<List<Repo>>

    fun saveRepo(repo: Repo): Single<Long>

    fun deleteRepo(repo: Repo): Single<Int>

    fun checkFavorite(repoId: Int): Single<Boolean>
}
