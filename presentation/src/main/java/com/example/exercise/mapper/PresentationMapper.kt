package com.example.exercise.mapper

import com.example.domain.entity.BaseEntity
import com.example.exercise.model.PresentationModel

interface PresentationMapper<DModel : BaseEntity, PModel : PresentationModel> {
    fun toModel(domainModel: DModel): PModel

    fun toDomain(presentationModel: PModel): DModel
}
