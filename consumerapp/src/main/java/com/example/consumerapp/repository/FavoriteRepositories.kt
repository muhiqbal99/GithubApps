package com.example.consumerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.consumerapp.datasource.UserDataSource
import com.example.consumerapp.model.User
import kotlinx.coroutines.Dispatchers

class FavoriteRepositories(private val source: UserDataSource) {

    fun getUserList():LiveData<List<User>> = liveData(Dispatchers.IO){
        emit(source.getUsers())
    }
}