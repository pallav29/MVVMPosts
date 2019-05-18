package com.learning.pallav.mvvmposts.injection.module.component

import com.learning.pallav.mvvmposts.injection.module.NetworkModule
import com.learning.pallav.mvvmposts.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Pallav Johari on 5/15/2019.
 */
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}