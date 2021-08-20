package com.example.submission2bfaa.ui.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bfaa.R
import com.example.submission2bfaa.databinding.ActivityMainBinding
import com.example.submission2bfaa.ui.adapter.UserAdapter
import com.example.submission2bfaa.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView()
        viewModel()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun recyclerView() {

        adapter = UserAdapter()

        binding.apply {
            rvGithub.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGithub.setHasFixedSize(true)
            rvGithub.adapter = adapter

            svUsername.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    searchUser(query)
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean = false
            })
        }

        adapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            Log.d("Check Data", selectedData.toString())
            startActivity(intent)
        }
    }

    private fun viewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        viewModel.getSearchUser().observe(this, {
            if (it.items.size > 0) {
                adapter.setData(it.items)
                state("success")
            } else {
                state("error")
            }
        })
    }

    private fun searchUser(query: String) {
        binding.apply {
            if (query.isEmpty()) return
            state("loading")
            viewModel.setSearchUsers(query)
        }
    }

    private fun state(state: String) {
        when (state) {
            "loading" -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.emptyLayout.activityError.visibility = View.GONE
                binding.rvGithub.visibility = View.GONE
            }
            "error" -> {
                binding.progressBar.visibility = View.GONE
                binding.rvGithub.visibility = View.GONE
                binding.emptyLayout.activityError.visibility = View.VISIBLE
                binding.emptyLayout.emptyText.text = getString(R.string.user_not_found)
            }
            else -> {
                binding.progressBar.visibility = View.GONE
                binding.emptyLayout.activityError.visibility = View.GONE
                binding.rvGithub.visibility = View.VISIBLE
            }
        }
    }

}
