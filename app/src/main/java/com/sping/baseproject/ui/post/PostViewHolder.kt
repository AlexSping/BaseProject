package com.sping.baseproject.ui.post

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.sping.baseproject.base.BaseRecyclerViewAdapter
import com.sping.baseproject.databinding.ItemPostBinding
import com.sping.baseproject.model.entity.Post

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root), LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun bind(post: Post, listener: BaseRecyclerViewAdapter.ItemClickListener<Post>) {
        binding.post = post
        binding.listener = listener
        binding.executePendingBindings()
    }
}