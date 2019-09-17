package com.sping.baseproject.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.sping.baseproject.R
import com.sping.baseproject.base.BaseRecyclerViewAdapter
import com.sping.baseproject.databinding.ItemPostBinding
import com.sping.baseproject.model.entity.Post

class PostsRecyclerViewAdapter constructor(private val itemClickListener: ItemClickListener<Post>) : BaseRecyclerViewAdapter<Post, PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItems()[position], itemClickListener)
    }

}