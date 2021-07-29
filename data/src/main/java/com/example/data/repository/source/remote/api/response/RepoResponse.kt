package com.example.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @Expose
    @SerializedName("total_count")
    val total_count: Int,
    @Expose
    @SerializedName("items")
    val items: List<RepoDTO>
)

data class RepoDTO(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("description")
    val description: String? = ""
)
