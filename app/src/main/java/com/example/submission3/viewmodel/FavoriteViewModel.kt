package com.example.submission3.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.submission3.data.local.FavoriteDao
import com.example.submission3.data.local.FavoriteDatabase
import com.example.submission3.model.User
import com.example.submission3.repository.FavoriteRepositories

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteDao: FavoriteDao = FavoriteDatabase.invoke(application).favoriteDao()
    private val favoriteRepositories: FavoriteRepositories = FavoriteRepositories(favoriteDao)

    fun getFavorite(): LiveData<List<User>> {
        return favoriteRepositories.getFavorite()
    }
}