package com.emreakcadag.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.emreakcadag.data.dbentity.TweetDbEntity

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
@Dao
interface TweetDao {

    @Query("SELECT * FROM tweet")
    fun getAll(): List<TweetDbEntity>

    @Query("SELECT * FROM tweet WHERE id LIKE :id LIMIT 1")
    fun findById(id: String): TweetDbEntity

    @Insert
    fun insertAll(vararg tweets: TweetDbEntity)

    @Delete
    fun delete(tweet: TweetDbEntity)
}