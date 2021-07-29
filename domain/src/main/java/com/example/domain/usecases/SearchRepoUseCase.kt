package com.example.domain.usecases

import com.example.domain.entity.Repo
import com.example.domain.repository.GitHubRepository
import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import com.example.domain.usecases.base.SingleUseCase
import io.reactivex.rxjava3.core.Single

class SearchRepoUseCase(
    private val gitHubRepository: GitHubRepository,
    subScheduler: SubScheduler,
    postScheduler: PostScheduler
) : SingleUseCase<SearchRepoUseCase.Params, List<Repo>>(subScheduler, postScheduler) {

    override fun build(params: Params): Single<List<Repo>> =
        gitHubRepository.searchRepo(params.keyword, params.page)

    class Params(val keyword: String, val page: Int)
}
