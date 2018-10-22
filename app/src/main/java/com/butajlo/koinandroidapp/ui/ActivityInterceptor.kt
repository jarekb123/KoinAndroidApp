package com.butajlo.koinandroidapp.ui

import android.app.Activity
import androidx.annotation.LayoutRes

interface ActivityInterceptor {
    fun setContentView(activity: Activity, @LayoutRes layoutRes: Int)
}