package com.example.submission3.provider

import android.content.ContentProvider
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.submission3.data.local.FavoriteDao
import com.example.submission3.data.local.FavoriteDatabase

abstract class ContentProvider : ContentProvider() {
    private lateinit var favoriteDao: FavoriteDao

    companion object{
        private const val AUTHORITY = "com.example.submission3"
        private const val TABLE_NAME = "tb_user_favorite"
        private const val USERLIST = 1
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        init {
            uriMatcher.addURI(
                AUTHORITY,
                TABLE_NAME,
                USERLIST
            )
        }
    }

    override fun onCreate(): Boolean {
        favoriteDao = FavoriteDatabase.invoke(context as Context).favoriteDao()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            USERLIST -> favoriteDao.getContent()
            else -> null
        }
    }
}