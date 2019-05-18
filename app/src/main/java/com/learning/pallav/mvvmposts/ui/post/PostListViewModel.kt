package com.learning.pallav.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.learning.pallav.mvvmposts.R
import com.learning.pallav.mvvmposts.base.BaseViewModel
import com.learning.pallav.mvvmposts.model.Post
import com.learning.pallav.mvvmposts.model.PostDao
import com.learning.pallav.mvvmposts.network.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Pallav Johari on 5/15/2019.
 */
class PostListViewModel(private val postDao: PostDao): BaseViewModel(){
    @Inject
    lateinit var postApi: PostApi
    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val postListAdapter: PostListAdapter = PostListAdapter()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }


    init{
        loadPosts()
    }

    private fun loadPosts(){
        subscription = Observable.fromCallable { postDao.all }
            .concatMap {
                    dbPostList ->
                if(dbPostList.isEmpty())
                    postApi.getPosts().concatMap {
                            apiPostList -> postDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList:List<Post>){
        postListAdapter.updatePostList(postList)
    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }
}