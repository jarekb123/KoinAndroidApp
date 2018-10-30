package com.butajlo.koinandroidapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.butajlo.koinandroidapp.ui.ActivityInterceptor
import org.koin.android.ext.android.inject
import org.koin.standalone.StandAloneContext.loadKoinModules

abstract class BaseActivity : AppCompatActivity() {

    private val activityInterceptor by inject<ActivityInterceptor>()

    @LayoutRes
    abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(activityModules)
        activityInterceptor.setContentView(this, layoutRes())
    }

}