package com.learning.pallav.mvvmposts.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Pallav Johari on 5/18/2019.
 */
@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}