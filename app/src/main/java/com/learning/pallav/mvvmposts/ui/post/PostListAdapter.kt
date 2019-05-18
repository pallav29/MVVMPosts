package com.learning.pallav.mvvmposts.ui.post

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.learning.pallav.mvvmposts.R
import com.learning.pallav.mvvmposts.databinding.ItemPostBinding
import com.learning.pallav.mvvmposts.model.Post

/**
 * Created by Pallav Johari on 5/17/2019.
 */
class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private lateinit var postList:List<Post>



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapter.ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList:List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: com.learning.pallav.mvvmposts.databinding.ItemPostBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = PostViewModel()

        fun bind(post:Post){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }
    }

}