package com.example.domain.usecases

import com.example.domain.entity.Repo
import com.example.domain.repository.GitHubRepository
import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import com.example.domain.usecases.base.SingleUseCase
import io.reactivex.rxjava3.core.Single

class DeleteRepoUseCase(
    private val gitHubRepository: GitHubRepository,
    subScheduler: SubScheduler,
    postScheduler: PostScheduler
): SingleUseCase<Repo, Int>(subScheduler, postScheduler) {

    override fun build(params: Repo): Single<Int> =
        gitHubRepository.deleteRepo(params)
}
