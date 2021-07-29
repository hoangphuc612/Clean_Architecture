package com.example.exercise.mapper

import com.example.domain.entity.Repo
import com.example.exercise.model.RepoModel

class RepoModelMapper : PresentationMapper<Repo, RepoModel> {

    override fun toModel(entity: Repo): RepoModel =
        RepoModel(id = entity.id, name = entity.name, description = entity.description)
}
