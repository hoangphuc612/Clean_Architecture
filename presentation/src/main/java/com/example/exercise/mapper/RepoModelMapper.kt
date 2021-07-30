package com.example.exercise.mapper

import com.example.domain.entity.Repo
import com.example.exercise.model.RepoModel

class RepoModelMapper : PresentationMapper<Repo, RepoModel> {

    override fun toModel(domainModel: Repo): RepoModel =
        RepoModel(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            isFavorite = domainModel.isFavorite
        )

    override fun toDomain(presentationModel: RepoModel): Repo =
        Repo(
            id = presentationModel.id,
            name = presentationModel.name,
            description = presentationModel.description,
            isFavorite = presentationModel.isFavorite
        )
}
