package com.sping.baseproject.utils.extentions

import android.annotation.SuppressLint
import android.content.ContextWrapper
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity

/**
 * Returns the [AppCompatActivity] that the [View] belongs too
 */
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

//region Inset handling

/**
 * Wrapper around [View.setOnApplyWindowInsetsListener] that keeps track of the original [View] padding and delegates the handle of insets to the passed function
 *
 * @param function anonymous [Function] that we delegate inset padding handle to
 */
@SuppressLint("RestrictedApi")
fun View.doOnApplyWindowInsets(function: (View, WindowInsets, InitialPadding) -> Unit) {
    // Create a snapshot of the view's padding state
    val initialPadding = InitialPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
    // Set an actual OnApplyWindowInsetsListener which proxies to the given lambda, also passing in the original padding state
    setOnApplyWindowInsetsListener { view, insets ->
        function(view, insets, initialPadding)
        // Always return the insets, so that children can also use them
        insets
    }
    // Request some insets
    requestApplyInsetsWhenAttached()
}

/**
 * Makes sure that [View.requestApplyInsets] is called when the [View] is attached to the window
 */
private fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to request when we are
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(view: View) {
                view.removeOnAttachStateChangeListener(this)
                view.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

/**
 * Holds all padding values of a [View]
 */
data class InitialPadding(
    val start: Int, val top: Int,
    val end: Int, val bottom: Int
)

//endregion