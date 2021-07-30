package com.example.domain.usecases

import com.example.domain.repository.GitHubRepository
import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import com.example.domain.usecases.base.SingleUseCase
import io.reactivex.rxjava3.core.Single

class CheckFavoriteUseCase(
    private val gitHubRepository: GitHubRepository,
    subScheduler: SubScheduler,
    postScheduler: PostScheduler
): SingleUseCase<Int, Boolean>(subScheduler, postScheduler) {

    override fun build(params: Int): Single<Boolean> =
        gitHubRepository.checkFavorite(params)
}
