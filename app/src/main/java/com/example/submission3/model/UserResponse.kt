package com.example.submission3.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    val total_count: String,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,
    val items: ArrayList<User>
) : Parcelable
