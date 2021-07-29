package com.example.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @Expose
    @SerializedName("items")
    val items: List<UserDTO>
)

data class UserDTO(
    @Expose
    @SerializedName("id")
    val id: Int = 0,
    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String = "",
    @Expose
    @SerializedName("login")
    val login: String = ""
)
