package com.example.exercise.model

data class UserModel(
    val id: Int = 0,
    val avatar_url: String = "",
    val login: String = ""
) : PresentationModel()
