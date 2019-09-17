package com.sping.baseproject.utils.bindings

import android.view.View
import androidx.databinding.BindingAdapter
import com.sping.baseproject.utils.extentions.doOnApplyWindowInsets

/**
 * Binding adapter that instructs the [View] to apply inset padding
 *
 * @param applyStart If inset padding should be applied at [View] start
 * @param applyTop If inset padding should be applied at [View] top
 * @param applyEnd If inset padding should be applied at [View] end
 * @param applyBottom If inset padding should be applied at [View] bottom
 */
@BindingAdapter(
    "paddingLeftSystemWindowInsets",
    "paddingTopSystemWindowInsets",
    "paddingRightSystemWindowInsets",
    "paddingBottomSystemWindowInsets",
    requireAll = false
)
fun applySystemWindows(
    view: View,
    applyStart: Boolean,
    applyTop: Boolean,
    applyEnd: Boolean,
    applyBottom: Boolean
) {
    view.doOnApplyWindowInsets { viewToApply, insets, padding ->
        val start = if (applyStart) insets.systemWindowInsetLeft else 0
        val top = if (applyTop) insets.systemWindowInsetTop else 0
        val end = if (applyEnd) insets.systemWindowInsetRight else 0
        val bottom = if (applyBottom) insets.systemWindowInsetBottom else 0

        viewToApply.setPadding(
            padding.start + start,
            padding.top + top,
            padding.end + end,
            padding.bottom + bottom
        )
    }
}