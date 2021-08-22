package com.example.submission2bfaa.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailUser = intent.getParcelableExtra<User>(EXTRA_DATA)
        showUser(detailUser)
        showFavorite(detailUser)
    }

    private fun showFavorite(detailUser: User?) {
        val username = detailUser!!.login
        val dataUser = detailUser.copy()

        viewModel.getFavoriteId(username).observe(this, {
            val checkUser = it?.login
            if (checkUser != null) {
                binding.fab.setImageResource(R.drawable.ic_favorite)
                binding.fab.setOnClickListener {
                    viewModel.deleteFavorite(dataUser)
                    Toast.makeText(this, R.string.delete_fav, Toast.LENGTH_SHORT).show()
                }
            } else {
                binding.fab.setImageResource(R.drawable.ic_unfavorite)
                binding.fab.setOnClickListener {
                    viewModel.insertFavorite(dataUser, true)
                    Toast.makeText(this, R.string.add_fav, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showUser(detailUser: User?) {

        val username = detailUser?.login

        viewModel = ViewModelProvider(
            this
        ).get(DetailViewModel::class.java)

        viewModel.setUserDetail(username!!)

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

        val bundle = Bundle()
        bundle.putString(EXTRA_DATA, username)

        val sectionPageAdapter = SectionPageAdapter(this, supportFragmentManager, bundle)
        binding.apply {
            viewPage.adapter = sectionPageAdapter
            tabLayout.setupWithViewPager(viewPage)
        }

        setActionBarTitle(username)
    }

    private fun setActionBarTitle(username: String?) {
        supportActionBar?.title = username
    }
}