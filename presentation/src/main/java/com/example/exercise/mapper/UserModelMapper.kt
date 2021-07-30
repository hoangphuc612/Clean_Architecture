package com.example.exercise.mapper

import com.example.domain.entity.User
import com.example.exercise.model.UserModel

class UserModelMapper : PresentationMapper<User, UserModel> {

    override fun toModel(domainModel: User): UserModel =
        UserModel(
            id = domainModel.id,
            avatar_url = domainModel.avatar_url,
            login = domainModel.login
        )

    override fun toDomain(presentationModel: UserModel): User =
        User(
            id = presentationModel.id,
            avatar_url = presentationModel.avatar_url,
            login = presentationModel.login
        )
}
