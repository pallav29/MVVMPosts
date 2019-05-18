package com.learning.pallav.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import com.learning.pallav.mvvmposts.base.BaseViewModel
import com.learning.pallav.mvvmposts.model.Post

/**
 * Created by Pallav Johari on 5/17/2019.
 */
class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}