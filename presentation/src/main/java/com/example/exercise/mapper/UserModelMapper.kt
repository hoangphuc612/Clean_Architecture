package com.example.exercise.mapper

import com.example.domain.entity.User
import com.example.exercise.model.UserModel

class UserModelMapper : PresentationMapper<User, UserModel> {

    override fun toModel(entity: User): UserModel =
        UserModel(id = entity.id, avatar_url = entity.avatar_url, login = entity.login)
}
