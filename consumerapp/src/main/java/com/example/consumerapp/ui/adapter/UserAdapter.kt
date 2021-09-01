package com.example.consumerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.consumerapp.R
import com.example.consumerapp.databinding.UserItemsBinding
import com.example.consumerapp.model.User

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var mData = ArrayList<User>()
    var onItemClick: ((User) -> Unit)? = null

    fun setData(items: ArrayList<User>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.user_items, parent, false)
        return UserViewHolder(mView)
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        userViewHolder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = UserItemsBinding.bind(itemView)
        fun bind(userItems: User) {

            binding.apply {
                Glide.with(itemView)
                    .load(userItems.avatarUrl)
                    .apply(
                        RequestOptions.circleCropTransform().placeholder(R.drawable.logo)
                    )
                    .into(ivAvatar)
                binding.tvUsername.text = userItems.login
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[bindingAdapterPosition])
            }
        }

    }
}
