package com.example.consumerapp.datasource

import android.content.ContentResolver
import com.example.consumerapp.contract.DatabaseContract
import com.example.consumerapp.contract.DatabaseContract.UserColumns.Companion.CONTENT_URI
import com.example.consumerapp.model.User

class UserDataSource(private val contentResolver: ContentResolver) {

    fun getUsers(): List<User> {
        val result: MutableList<User> = mutableListOf()

        val cursor = contentResolver.query(
            CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.apply {
            while (moveToNext()) {
                result.add(
                    User(
                        getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.ID)),
                        getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOGIN)),
                        getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.AVATAR_URL)),
                        getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.NAME)),
                        getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOCATION)),
                        getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.COMPANY)),
                        getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.PUBLIC_REPOS)),
                        getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWERS)),
                        getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWING))
                    )
                )
            }
            close()
        }
        return result.toList()
    }
}