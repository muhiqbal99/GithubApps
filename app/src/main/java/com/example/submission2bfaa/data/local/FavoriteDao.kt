package com.example.submission2bfaa.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.submission2bfaa.model.User

@Dao
interface FavoriteDao {

    //    @Query("SELECT * from tb_user_favorite WHERE login = :username")
//    fun getUserDetail(username: String): User?
////
    @Query("SELECT * FROM tb_user_favorite")
    fun getUser(): LiveData<User>

    @Query("SELECT * FROM tb_user_favorite WHERE login = :username AND isFavorite = 1")
     fun getFavorite(username: String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(user: User)

    @Delete
    suspend fun deleteFavorite(model: User): Int

    @Update
    suspend fun updateFavorite(favorite: User)
}