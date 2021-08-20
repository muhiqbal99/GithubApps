package com.example.submission2bfaa.repository

import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.model.User

class FavoriteRepositories(private val favoriteDao: FavoriteDao) {

    suspend fun insert(user: User) {
        favoriteDao.insertFavorite(user)
    }

    suspend fun delete(user: User) {
        favoriteDao.deleteFavorite(user)
    }

    suspend fun setFavorite(user: User, newState: Boolean)  {
        user.isFavorite = newState
        favoriteDao.updateFavorite(user)
    }

}