package com.sping.baseproject.utils.extentions

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.View.*
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * Sets an [AppCompatActivity] to fullscreen ( Root [View] will be displayed bellow system UI like bottom navigation, status bar etc )
 *
 * @param statusBarColorRes the [ColorRes] to be applied at the top status bar
 * @param bottomBarColorRes the [ColorRes] to be applied at the bottom navigation
 * @param darkMode a [Boolean] that declares if system UI should switch to light theme
 */
fun AppCompatActivity.setFullScreen(
    @ColorRes statusBarColorRes: Int = -1, @ColorRes bottomBarColorRes: Int = -1, darkMode: Boolean = false
) {
    window?.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (darkMode && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
        } else if (darkMode && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        } else {
            decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }

        statusBarColor =
            if (statusBarColorRes == -1) Color.TRANSPARENT
            else ContextCompat.getColor(this@setFullScreen, statusBarColorRes)

        navigationBarColor =
            if (bottomBarColorRes == -1) Color.TRANSPARENT
            else ContextCompat.getColor(this@setFullScreen, bottomBarColorRes)
    }
}

