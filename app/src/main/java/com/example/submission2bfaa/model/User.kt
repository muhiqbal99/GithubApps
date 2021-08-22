package com.example.submission2bfaa.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_user_favorite")
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo(name = "login")
    val login: String?,

    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    val avatarUrl: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "location")
    val location: String?,

    @ColumnInfo(name = "company")
    val company: String?,

    @ColumnInfo(name = "public_repos")
    val public_repos: Int,

    @ColumnInfo(name = "followers")
    val followers: Int,

    @ColumnInfo(name = "following")
    val following: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
