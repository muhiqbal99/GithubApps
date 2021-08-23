package com.example.submission3.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.submission3.data.local.FavoriteDao
import com.example.submission3.data.local.FavoriteDatabase

class ContentProvider : ContentProvider() {

    private lateinit var favoriteDao: FavoriteDao

    companion object {
        private const val AUTHORITY = "com.example.submission3"
        private const val TABLE_NAME = "tb_user_favorite"
        private const val ID_FAVORITE_DATA = 1
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

        init {
            uriMatcher.addURI(AUTHORITY, TABLE_NAME, ID_FAVORITE_DATA)
        }
    }

    override fun onCreate(): Boolean {
        favoriteDao = FavoriteDatabase.invoke(context as Context).favoriteDao()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?,
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            ID_FAVORITE_DATA -> favoriteDao.getContent()
            else -> null
        }
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

}