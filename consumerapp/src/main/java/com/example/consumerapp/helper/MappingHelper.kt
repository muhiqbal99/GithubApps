package com.example.consumerapp.helper

import android.database.Cursor
import com.example.consumerapp.contract.DatabaseContract
import com.example.consumerapp.model.User
import java.util.*

object MappingHelper {

    fun mapCursorToArrayList(userCursor: Cursor?): ArrayList<User> {
        val userList = ArrayList<User>()

        userCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.ID))
                val login = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOGIN))
                val avatarurl =
                    getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.AVATAR_URL))
                val name = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.NAME))
                val location =
                    getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOCATION))
                val company = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.COMPANY))
                val publicrepos =
                    getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.PUBLIC_REPOS))
                val followers =
                    getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWERS))
                val following =
                    getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWING))
                userList.add(User(id,
                    login,
                    avatarurl,
                    name,
                    location,
                    company,
                    publicrepos,
                    followers,
                    following))
            }
        }
        return userList
    }
}