package com.example.submission2bfaa.repository

import androidx.lifecycle.LiveData
import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.model.User

class FavoriteRepositories(private val favoriteDao: FavoriteDao) {

    fun getFavorite(): LiveData<List<User>> {
        return favoriteDao.getFavorite()
    }

    fun getFavoriteId(username: String): LiveData<User> {
        return favoriteDao.getFavoriteId(username)
    }

    suspend fun insertFavorite(user: User, newState: Boolean) {
        user.isFavorite = newState
        favoriteDao.insertFavorite(user)
    }

    fun deleteFavorite(user: User) {
        favoriteDao.deleteFavorite(user)
    }

}