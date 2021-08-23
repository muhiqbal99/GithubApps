package com.example.consumerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.consumerapp.datasource.UserDataSource
import com.example.consumerapp.repository.FavoriteRepositories

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val favoriterepository: FavoriteRepositories

    init {
        val source = UserDataSource(application.contentResolver)
        favoriterepository = FavoriteRepositories(source)
    }

    var userLists = favoriterepository.getUserList()
}