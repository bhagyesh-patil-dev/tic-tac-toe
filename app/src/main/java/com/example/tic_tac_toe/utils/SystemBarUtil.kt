package com.example.tic_tac_toe.utils

import android.graphics.Color
import android.view.View
import android.view.Window

object SystemBarUtil {
    @Suppress("DEPRECATION")
    fun setTransparentSystemBars(
        window: Window, isStatusBarTransparent: Boolean, isNavigationBarTransparent: Boolean
    ) {
        if (isStatusBarTransparent) {
            window.statusBarColor = Color.TRANSPARENT
        }
        if (isNavigationBarTransparent) {
            window.navigationBarColor = Color.TRANSPARENT
        }

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}