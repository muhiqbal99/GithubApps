package com.example.consumerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.consumerapp.datasource.UserDataSource
import com.example.consumerapp.repository.FavoriteRepositories

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FavoriteRepositories

    init {
        val source = UserDataSource(application.contentResolver)
        repository = FavoriteRepositories(source)
    }

    var userLists = repository.getUserList()
}