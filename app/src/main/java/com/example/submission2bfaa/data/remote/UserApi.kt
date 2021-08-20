package com.example.submission2bfaa.data.remote

import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("search/users")
    suspend fun getUsers(
        @Query("q") query: String
    ): UserResponse

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): User

    @GET("users/{username}/followers")
    suspend fun getFollowers(
        @Path("username") username: String
    ): List<User>

    @GET("users/{username}/following")
    suspend fun getFollowing(
        @Path("username") username: String
    ): List<User>

}