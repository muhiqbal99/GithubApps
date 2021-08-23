package com.example.submission3.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.submission3.R
import com.example.submission3.databinding.FragmentMainBinding
import com.example.submission3.ui.activity.DetailActivity
import com.example.submission3.ui.adapter.UserAdapter
import com.example.submission3.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView()
        viewModel()
    }

    private fun recyclerView() {

        adapter = UserAdapter()

        binding.apply {
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
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }

    private fun viewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        viewModel.getSearchUser().observe(viewLifecycleOwner, {
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
