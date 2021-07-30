package com.example.data.mapper

import com.example.data.repository.source.local.sqlite.entity.RepoEntity
import com.example.data.repository.source.remote.api.response.RepoDTO
import com.example.data.repository.source.remote.api.response.UserDTO
import com.example.domain.entity.Repo
import com.example.domain.entity.User

class Mapper {

    fun transform(userDTO: UserDTO): User =
        User(userDTO.id, userDTO.avatar_url, userDTO.login)

    fun transform(listUser: List<UserDTO>): List<User> =
        listUser.map { transform(it) }

    fun transformRepo(repoDTO: RepoDTO): Repo =
        Repo(repoDTO.id, repoDTO.name, repoDTO.description)

    fun transformRepo(listRepo: List<RepoDTO>): List<Repo> =
        listRepo.map { transformRepo(it) }

    fun transformToEntity(model: Repo): RepoEntity =
        RepoEntity(
            model.id,
            model.name,
            model.description,
        )

    fun transformRepo(repoEntity: RepoEntity): Repo =
        Repo(repoEntity.id, repoEntity.name, repoEntity.description)

    fun transformRepos(listRepo: List<RepoEntity>): List<Repo> =
        listRepo.map { transformRepo(it) }
}
