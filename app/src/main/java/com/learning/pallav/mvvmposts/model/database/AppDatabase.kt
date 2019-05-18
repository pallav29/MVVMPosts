package com.learning.pallav.mvvmposts.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.learning.pallav.mvvmposts.model.Post
import com.learning.pallav.mvvmposts.model.PostDao

/**
 * Created by Pallav Johari on 5/18/2019.
 */

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
