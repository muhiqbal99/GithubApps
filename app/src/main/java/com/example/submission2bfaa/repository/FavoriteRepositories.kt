package com.example.submission2bfaa.repository

import androidx.lifecycle.LiveData
import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.model.User

class FavoriteRepositories(private val favoriteDao: FavoriteDao) {

    fun getFavorite(username: String): LiveData<User> {
        return favoriteDao.getFavorite(username)
    }

    suspend fun setFavorite(user: User, newState: Boolean) {
        user.isFavorite = newState
        favoriteDao.insertFavorite(user)
    }

}