package com.example.submission3.data.local

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.submission3.model.User

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM tb_user_favorite WHERE isFavorite = 1")
    fun getFavorite(): LiveData<List<User>>

    @Query("SELECT * FROM tb_user_favorite WHERE login = :username AND isFavorite = 1")
    fun getFavoriteId(username: String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(user: User)

    @Delete
    fun deleteFavorite(user: User)

    @Query("SELECT * from tb_user_favorite ORDER BY login ASC")
    fun getContent(): Cursor
}