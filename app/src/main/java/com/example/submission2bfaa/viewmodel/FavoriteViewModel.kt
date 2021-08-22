package com.example.submission2bfaa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.data.local.FavoriteDatabase
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.repository.FavoriteRepositories

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteDao: FavoriteDao = FavoriteDatabase.invoke(application).favoriteDao()
    private val favoriteRepositories: FavoriteRepositories = FavoriteRepositories(favoriteDao)

    fun getFavorite(): LiveData<List<User>> {
        return favoriteRepositories.getFavorite()
    }
}