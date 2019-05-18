package com.learning.pallav.mvvmposts.network

import com.learning.pallav.mvvmposts.model.Post
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by Pallav Johari on 5/15/2019.
 */
/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}