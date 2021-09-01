package com.example.consumerapp.ui.activity

import android.content.ContentValues.TAG
import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.consumerapp.contract.DatabaseContract.UserColumns.Companion.CONTENT_URI
import com.example.consumerapp.databinding.ActivityMainBinding
import com.example.consumerapp.helper.MappingHelper
import com.example.consumerapp.ui.adapter.UserAdapter
import com.example.consumerapp.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadNotesAsync()
            }
        }

        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)

        loadNotesAsync()
    }

    private fun loadNotesAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUser = async(Dispatchers.IO) {
                val cursor = contentResolver?.query(CONTENT_URI, null, null, null, null)
                MappingHelper.mapCursorToArrayList(cursor)
            }
            val users = deferredUser.await()
            binding.progressBar.visibility = View.INVISIBLE
            if (!users.isNullOrEmpty()) {
                adapter.setData(users)
                showLoading(false)
                Log.d(TAG, "loadNotesAsync: ada datanya")
            } else {
                showLoading(true)
            }
        }
    }

//    private fun listUser() {
//
//        userViewModel = ViewModelProvider(
//            viewModelStore,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(UserViewModel::class.java)
//
//        userViewModel.userLists.observe(this, { users ->
//            if (!users.isNullOrEmpty()) {
//                adapter.setData(users as ArrayList<User>)
//                showLoading(false)
//            } else {
//                showLoading(true)
//            }
//        })
//    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.GONE
            binding.emptyLayout.activityError.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}