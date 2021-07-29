package com.example.exercise.mapper

import com.example.domain.entity.BaseEntity
import com.example.exercise.model.PresentationModel

interface PresentationMapper<Entity : BaseEntity, PModel : PresentationModel> {
    fun toModel(entity: Entity): PModel
}
