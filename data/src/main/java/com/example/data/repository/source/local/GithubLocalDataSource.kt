package com.example.data.repository.source.local

import com.example.data.repository.source.local.sqlite.dao.RepoDao
import com.example.data.repository.source.local.sqlite.entity.RepoEntity
import io.reactivex.rxjava3.core.Single

class GithubLocalDataSource(
    private val repoDao: RepoDao
) {

    fun saveRepo(repoEntity: RepoEntity): Single<Long> =
        Single.create { emitter ->
            try {
                emitter.onSuccess(repoDao.save(repoEntity))
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }

    fun deleteRepo(repoEntity: RepoEntity): Single<Int> =
        Single.create { emitter ->
            try {
                emitter.onSuccess(repoDao.delete(repoEntity))
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }

    fun checkFavorite(repoId: Int): Single<Boolean> =
        Single.fromCallable { repoDao.checkFavorite(repoId) }
}
