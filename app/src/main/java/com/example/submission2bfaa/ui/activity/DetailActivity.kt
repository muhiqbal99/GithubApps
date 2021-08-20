package com.example.submission2bfaa.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2bfaa.R
import com.example.submission2bfaa.databinding.ActivityDetailUserBinding
import com.example.submission2bfaa.model.User
import com.example.submission2bfaa.ui.adapter.SectionPageAdapter
import com.example.submission2bfaa.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val detailUser = intent.getParcelableExtra<User>(EXTRA_DATA)

//        binding.fab.setOnClickListener { addOrRemoveFavorite() }
        showUser(detailUser)
    }

    private fun showUser(detailUser: User?) {

//        val database = FavoriteDatabase.invoke(this)
//        val repository = FavoriteRepositories(database)
//        val factory = ViewModelFactory(repository)

        viewModel = ViewModelProvider(
            this
        ).get(DetailViewModel::class.java)

        viewModel.setUserDetail(detailUser!!.login)

        viewModel.getUserDetail().observe(this, {
            if (it != null) {
                binding.apply {
                    tvName.text = it.name
                    tvCompany.text = it.company ?: "-"
                    tvLocation.text = it.location ?: "-"
                    tvRepo.text = it.public_repos.toString()
                    tvFollowers.text = it.followers.toString()
                    tvFollowing.text = it.following.toString()

                    Glide.with(this@DetailActivity)
                        .load(it.avatarUrl)
                        .apply(
                            RequestOptions.circleCropTransform()
                                .placeholder(R.drawable.logo_rounded)
                        )
                        .into(ivAvatar)
                }
            }
        })

        var statusFavorite = detailUser.isFavorite
        setStatusFavorite(statusFavorite)
        binding.fab.setOnClickListener {
            statusFavorite = !statusFavorite
            viewModel.setFavorite(detailUser, statusFavorite)
            setStatusFavorite(statusFavorite)
        }

        val bundle = Bundle()
        bundle.putString(EXTRA_USERNAME, detailUser.login)

        val sectionPageAdapter = SectionPageAdapter(this, supportFragmentManager, bundle)
        binding.apply {
            viewPage.adapter = sectionPageAdapter
            tabLayout.setupWithViewPager(viewPage)
        }

        setActionBarTitle(detailUser.login)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_red
                )
            )
        }
    }

    private fun setActionBarTitle(username: String?) {
        supportActionBar?.title = username
    }
}