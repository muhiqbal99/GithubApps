package com.example.submission2bfaa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.data.local.FavoriteDatabase
import com.example.submission2bfaa.data.remote.RetrofitInstance
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.repository.FavoriteRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteDao: FavoriteDao = FavoriteDatabase.invoke(application).favoriteDao()
    private val favoriteRepositories: FavoriteRepositories

    init {
        favoriteRepositories = FavoriteRepositories(favoriteDao)
    }

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

    fun getFavorite(): LiveData<User> = favoriteDao.getFavorite()

    fun setFavorite(user: User, newStatus: Boolean) = viewModelScope.launch {
        favoriteRepositories.setFavorite(user, newStatus)
    }
}