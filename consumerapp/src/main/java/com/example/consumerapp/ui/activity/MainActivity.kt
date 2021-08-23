package com.example.consumerapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.consumerapp.databinding.ActivityMainBinding
import com.example.consumerapp.ui.adapter.UserAdapter
import com.example.consumerapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var usersAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usersAdapter = UserAdapter()

        binding.rvGithub.apply {
            adapter = usersAdapter
        }

        listUser()
    }

    private fun listUser() {

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.userLists.observe(this, { users ->
            if (users.size > 0) {
                usersAdapter.setData(users)
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