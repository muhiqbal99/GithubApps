package com.example.submission2bfaa.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission2bfaa.data.local.FavoriteDatabase
import com.example.submission2bfaa.model.User

class FavoriteRepositories(private val db: FavoriteDatabase) {

    private val favorite: MutableLiveData<Boolean> = MutableLiveData()

    suspend fun insert(user: User){
        db.favoriteDao().insertFavorite(user)
        favorite.value = true
    }

    suspend fun delete(user: User){
        db.favoriteDao().deleteFavorite(user)
        favorite.value = false
    }
    val isFavorite: LiveData<Boolean> = favorite
}