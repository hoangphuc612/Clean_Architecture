package com.example.domain.entity

data class Repo(
    val id: Int = 0,
    val name: String = "",
    val description: String?,
    var isFavorite: Boolean = false
) : BaseEntity()
