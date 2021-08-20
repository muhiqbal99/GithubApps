package com.example.submission2bfaa.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission2bfaa.data.local.FavoriteDatabase
import com.example.submission2bfaa.repository.FavoriteRepositories
import com.example.submission2bfaa.viewmodel.DetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private var favoriteRepositories: FavoriteRepositories) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(favoriteRepositories) as T
    }
}