package com.example.domain.usecases

import com.example.domain.entity.User
import com.example.domain.repository.GitHubRepository
import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import com.example.domain.usecases.base.SingleUseCase
import io.reactivex.rxjava3.core.Single

class SearchUserUseCase(
    private val gitHubRepository: GitHubRepository,
    subScheduler: SubScheduler,
    postScheduler: PostScheduler
) : SingleUseCase<SearchUserUseCase.Params, List<User>>(subScheduler, postScheduler) {

    override fun build(params: Params): Single<List<User>> =
        gitHubRepository.searchUser(params.keyword, params.page)

    class Params(val keyword: String, val page: Int)
}
