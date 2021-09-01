package com.example.submission3.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3.databinding.FavoriteFragmentBinding
import com.example.submission3.model.User
import com.example.submission3.ui.activity.DetailActivity
import com.example.submission3.ui.adapter.UserAdapter
import com.example.submission3.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var binding: FavoriteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val userAdapter = UserAdapter()
            userAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel = ViewModelProvider(
                this
            ).get(FavoriteViewModel::class.java)

            favoriteViewModel.getFavorite().observe(viewLifecycleOwner, { dataUser ->
                userAdapter.setData(dataUser as ArrayList<User>)
                binding.errorLayout.root.visibility =
                    if (dataUser.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.recyclerFav) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = userAdapter
            }
        }
    }

}
