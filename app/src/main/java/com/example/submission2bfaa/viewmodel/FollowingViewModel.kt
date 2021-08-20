package com.example.submission2bfaa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FollowingViewModel : ViewModel() {
    private var listUsers = MutableLiveData<List<User>>()

    fun setListFollowing(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.apiClient.getFollowing(username)
            listUsers.postValue(response)
        }
    }

    fun getListFollowing(): MutableLiveData<List<User>> {
        return listUsers
    }
}
