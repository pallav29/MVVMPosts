package com.learning.pallav.mvvmposts.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Pallav Johari on 5/15/2019.
 */
/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */
@Entity
data class Post(
    val userId: Int,
    @field:PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)