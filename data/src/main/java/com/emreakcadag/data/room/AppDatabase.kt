package com.emreakcadag.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emreakcadag.data.dao.TweetDao
import com.emreakcadag.data.dbentity.TweetDbEntity

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
@Database(entities = [TweetDbEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tweetDao(): TweetDao
}