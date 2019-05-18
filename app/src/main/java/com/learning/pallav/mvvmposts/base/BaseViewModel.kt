package com.learning.pallav.mvvmposts.base

import android.arch.lifecycle.ViewModel
import com.learning.pallav.mvvmposts.injection.module.NetworkModule
import com.learning.pallav.mvvmposts.injection.module.component.DaggerViewModelInjector
import com.learning.pallav.mvvmposts.injection.module.component.ViewModelInjector
import com.learning.pallav.mvvmposts.ui.post.PostListViewModel


/**
 * Created by Pallav Johari on 5/15/2019.
 */
abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)

        }
    }
}