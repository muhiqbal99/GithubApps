package com.example.consumerapp.ui.activity

import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.consumerapp.contract.DatabaseContract.UserColumns.Companion.CONTENT_URI
import com.example.consumerapp.databinding.ActivityMainBinding
import com.example.consumerapp.helper.MappingHelper
import com.example.consumerapp.ui.adapter.UserAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()

        binding.rvGithub.setHasFixedSize(true)
        binding.rvGithub.adapter = adapter

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadUser()
            }
        }

        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)

        loadUser()
    }

    private fun loadUser() {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val deferredUser = async(Dispatchers.IO) {
                val cursor = contentResolver?.query(CONTENT_URI, null, null, null, null)
                MappingHelper.mapCursorToArrayList(cursor)
            }
            val users = deferredUser.await()
            binding.progressBar.visibility = View.INVISIBLE
            if (users.size > 0) {
                adapter.setData(users)
                showLoading(false)
            } else {
                showLoading(true)
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.GONE
            binding.emptyLayout.activityError.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}