package com.example.data.mapper

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
        Repo(repoDTO.id, repoDTO.name)

    fun transformRepo(listRepo: List<RepoDTO>): List<Repo> =
        listRepo.map { transformRepo(it) }
}
