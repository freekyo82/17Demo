package com.bruce.project.demo.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserData(
    @Json(name = "total_count") val totalCount: Int,
    @Json(name = "incomplete_results") val incompleteResults: Boolean,
    @Json(name = "items") val users: List<UserItems>
)

@JsonClass(generateAdapter = true)
data class UserItems(
    @Json(name = "login") val login: String,
    @Json(name = "id") val id: Int,
    @Json(name = "avatar_url") val avatarUrl: String
)