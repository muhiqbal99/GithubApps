package com.example.submission2bfaa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission2bfaa.data.remote.RetrofitInstance
import com.example.submission2bfaa.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private var listUsers = MutableLiveData<UserResponse>()

    fun setSearchUsers(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.apiClient.getUsers(query)
            listUsers.postValue(response)
        }
    }


    fun getSearchUser(): MutableLiveData<UserResponse> {
        return listUsers
    }
}