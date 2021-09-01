package com.example.submission3.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.submission3.data.local.FavoriteDao
import com.example.submission3.data.local.FavoriteDatabase
import com.example.submission3.data.remote.RetrofitInstance
import com.example.submission3.model.User
import com.example.submission3.repository.FavoriteRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteDao: FavoriteDao = FavoriteDatabase.invoke(application).favoriteDao()
    private val favoriteRepositories: FavoriteRepositories = FavoriteRepositories(favoriteDao)

    private val user = MutableLiveData<User>()

    fun setUserDetail(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.apiClient.getUserDetail(username)
            user.postValue(response)
        }
    }

    fun getUserDetail(): LiveData<User> {
        return user
    }

    fun getFavoriteId(username: String): LiveData<User> {
        return favoriteRepositories.getFavoriteId(username)
    }

    fun insertFavorite (user: User,newStatus: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepositories.insertFavorite(user, newStatus)
        }
    }

    fun deleteFavorite(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepositories.deleteFavorite(user)
        }
    }
}