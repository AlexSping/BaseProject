package com.sping.baseproject.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sping.baseproject.base.BaseRecyclerViewAdapter
import com.sping.baseproject.model.entity.Post
import com.sping.baseproject.model.repo.PostRepo
import com.sping.baseproject.network.CallState
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class PostFragmentViewModel @Inject constructor(private val postRepo: PostRepo) : ViewModel(), BaseRecyclerViewAdapter.ItemClickListener<Post>{

    private val _postsErrorLiveData = MutableLiveData<Int>()

    val postErrorLiveData: LiveData<Int> = _postsErrorLiveData

    val postsRecyclerViewAdapter by lazy { PostsRecyclerViewAdapter(this) }

    init {
        viewModelScope.launch {
            when(val postsResult: CallState<List<Post>> = postRepo.getPosts()){
                is CallState.Success -> { postsRecyclerViewAdapter.setItems(postsResult.data)}
                is CallState.Error -> { _postsErrorLiveData.postValue(postsResult.code)}
            }
        }
    }

    override fun onItemClicked(item: Post) {
        Timber.i(item.body)
    }

}
