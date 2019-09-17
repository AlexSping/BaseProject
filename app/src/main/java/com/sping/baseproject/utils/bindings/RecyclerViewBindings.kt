package com.sping.baseproject.utils.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sping.baseproject.ui.custom.PaginatedRecyclerView

/**
 * [BindingAdapter] that sets a [RecyclerView.Adapter] to a [RecyclerView]
 *
 * @param adapter the [RecyclerView.Adapter] object
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

//region PaginatedRecyclerView on bottom reached handling

/**
 * [BindingAdapter] that sets a [PaginatedRecyclerView.onBottomReachedListener] to a [PaginatedRecyclerView]
 *
 * @param listener the [PaginatedRecyclerView.onBottomReachedListener] object
 */
@BindingAdapter("onBottomListener")
fun setOnBottomReachListener(
    paginatedRecyclerView: PaginatedRecyclerView,
    listener: PaginatedRecyclerView.OnBottomReachedListener?
) {
    paginatedRecyclerView.onBottomReachedListener = listener
}

/**
 * [BindingAdapter] that sets the bottom reach offset of a [PaginatedRecyclerView]
 *
 * @param offset value of how many item views the [PaginatedRecyclerView] much reach to trigger the [PaginatedRecyclerView.OnBottomReachedListener]
 */
@BindingAdapter("bottomReachOffset")
fun setBottomReachOffser(
    paginatedRecyclerView: PaginatedRecyclerView,
    offset: Int
){
    paginatedRecyclerView.bottomReachOffset = offset
}

//endregion
