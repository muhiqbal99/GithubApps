package com.example.submission2bfaa.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.submission2bfaa.model.User

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
}