package com.example.submission2bfaa.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bfaa.databinding.FavoriteFragmentBinding
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.ui.activity.DetailActivity
import com.example.submission2bfaa.ui.adapter.UserAdapter

//class FavoriteFragment : Fragment() {
//
//    private lateinit var favoriteViewModel: FavoriteViewModel
//    private lateinit var binding: FavoriteFragmentBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FavoriteFragmentBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (activity != null) {
//
//            val userAdapter = UserAdapter()
//            userAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.EXTRA_USERNAME, selectedData.login)
//                startActivity(intent)
//            }
//
//            favoriteViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
//                FavoriteViewModel::class.java
//            )
//
//            favoriteViewModel.getFavorite().observe(viewLifecycleOwner, Observer { da ->
//                userAdapter.setData(dataUser as ArrayList<User>)
//                binding.errlayout.root.visibility =
//                    if (dataUser.isNotEmpty()) View.GONE else View.VISIBLE
//            })
//
//            with(binding.recyclerFav) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = userAdapter
//            }
//        }
//    }
//
//}
