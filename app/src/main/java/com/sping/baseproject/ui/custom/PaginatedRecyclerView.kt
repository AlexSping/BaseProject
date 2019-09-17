package com.sping.baseproject.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Extended class of [RecyclerView] that detects when it reaches the end
 */
class PaginatedRecyclerView : RecyclerView {

    var onBottomReachedListener: OnBottomReachedListener? = null

    var bottomReachOffset = 0

    private var previousItemCount = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onScrolled(dx: Int, dy: Int) {
        super.onScrolled(dx, dy)
        val linearLayoutManager = this.layoutManager as LinearLayoutManager
        val itemCount = linearLayoutManager.itemCount
        if (onBottomReachedListener != null
            && itemCount > 0
            && previousItemCount != itemCount
            && itemCount <= linearLayoutManager.findLastVisibleItemPosition() + bottomReachOffset + 1
        ) {
            previousItemCount = linearLayoutManager.itemCount
            onBottomReachedListener!!.onBottomReached()
        }
    }

    /**
     * Listener that triggers when [PaginatedRecyclerView] reaches the bottom item [View] minus the [bottomReachOffset]
     */
    interface OnBottomReachedListener {
        fun onBottomReached()
    }
}
