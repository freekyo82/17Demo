package com.bruce.project.demo.api

import com.bruce.project.demo.entity.UserData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitApi {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users/{user}")
    suspend fun getUserInfo(
        @Path("user") user: String,
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): UserData
}