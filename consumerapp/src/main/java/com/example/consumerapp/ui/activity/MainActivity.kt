package com.example.consumerapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.consumerapp.databinding.ActivityMainBinding
import com.example.consumerapp.model.User
import com.example.consumerapp.ui.adapter.UserAdapter
import com.example.consumerapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()

        binding.rvGithub.apply {
            setHasFixedSize(true)
            adapter = adapter
        }

        listUser()
    }

    private fun listUser() {

        userViewModel = ViewModelProvider(
            viewModelStore,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(UserViewModel::class.java)

        userViewModel.userLists.observe(this, { users ->
            if (!users.isNullOrEmpty()) {
                adapter.setData(users as ArrayList<User>)
                showLoading(false)
            } else {
                showLoading(true)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
//            binding.emptyLayout.activityError.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}