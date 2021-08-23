package com.example.consumerapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val name: String?,
    val location: String?,
    val company: String?,
    val public_repos: Int,
    val followers: Int,
    val following: Int
) : Parcelable
