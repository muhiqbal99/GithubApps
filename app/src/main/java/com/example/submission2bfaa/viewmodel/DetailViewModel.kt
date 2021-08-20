package com.example.submission2bfaa.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission2bfaa.data.remote.RetrofitInstance
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.repository.FavoriteRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val favoriteRepositories: FavoriteRepositories) : ViewModel() {

    val detail = MutableLiveData<User>()

    fun setUserDetail(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.apiClient.getUserDetail(username)
            detail.postValue(response)
        }
    }

    fun getUserDetail(): LiveData<User> {
        return detail
    }

    fun addFavorite(user: User) = viewModelScope.launch {
        favoriteRepositories.insert(user)
    }

    fun removeFavorite(user: User) = viewModelScope.launch {
        favoriteRepositories.delete(user)
    }

    val isFavorite: LiveData<Boolean> = favoriteRepositories.isFavorite
}