package com.example.submission2bfaa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission2bfaa.data.local.FavoriteDao
import com.example.submission2bfaa.data.local.FavoriteDatabase
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.repository.FavoriteRepositories
import kotlinx.coroutines.launch

//class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
//
//    val dataFavorite: LiveData<List<User>>
//
//    init {
//        val favoriteDao: FavoriteDao = FavoriteDatabase.invoke(application).favoriteDao()
//        dataFavorite = FavoriteRepositories.
//    }
//
//    val getFavorite = viewModelScope.launch {
//        favoriteRepositories.getFavorite()
//    }
//}