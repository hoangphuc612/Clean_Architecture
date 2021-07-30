package com.example.data.repository

import com.example.data.mapper.Mapper
import com.example.data.repository.source.local.GithubLocalDataSource
import com.example.data.repository.source.remote.GithubRemoteDataSource
import com.example.domain.entity.Repo
import com.example.domain.entity.User
import com.example.domain.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single

class GitHubRepositoryImpl(
    private val localDataSource: GithubLocalDataSource,
    private val remoteDataSource: GithubRemoteDataSource,
    private val mapper: Mapper
) : GitHubRepository {

    override fun searchUser(userName: String, page: Int): Single<List<User>> =
        remoteDataSource.searchUser(userName, page).map {
            mapper.transform(it.items)
        }

    override fun searchRepo(repoName: String, page: Int): Single<List<Repo>> =
        remoteDataSource.searchRepo(repoName, page).map {
            mapper.transformRepo(it.items)
        }

    override fun saveRepo(repo: Repo): Single<Long> =
        localDataSource.saveRepo(mapper.transformToEntity(repo))

    override fun deleteRepo(repo: Repo): Single<Int> =
        localDataSource.deleteRepo(mapper.transformToEntity(repo))

    override fun checkFavorite(repoId: Int): Single<Boolean> =
        localDataSource.checkFavorite(repoId)
}
