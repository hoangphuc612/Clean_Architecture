package com.example.domain.entity

data class User(
    val id: Int = 0,
    val avatar_url: String = "",
    val login: String = ""
) : BaseEntity()
