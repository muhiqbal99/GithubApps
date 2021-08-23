package com.example.submission3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission3.model.User
import com.example.submission3.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FollowersViewModel : ViewModel() {
    private var listUsers = MutableLiveData<List<User>>()

    fun setListFollowers(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.apiClient.getFollowers(username)
            listUsers.postValue(response)
        }
    }

    fun getListFollowers(): MutableLiveData<List<User>> {
        return listUsers
    }
}