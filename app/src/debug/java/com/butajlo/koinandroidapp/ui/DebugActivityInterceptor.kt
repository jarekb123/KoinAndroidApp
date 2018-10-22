package com.butajlo.koinandroidapp.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.butajlo.koinandroidapp.R

class DebugActivityInterceptor(private val debugPreferences: DebugPreferences)
    : ActivityInterceptor {

    private lateinit var debugLayout: View

    /**
     * Wraps Activity Layout in Debug DrawerLayout
     * with some debug helpers like switches (eg. turn on/off mock responses)
     */
    override fun setContentView(activity: Activity, layoutRes: Int) {
        debugLayout = LayoutInflater.from(activity).inflate(R.layout.debug_drawer, null)
        val activityContainer = debugLayout.findViewById<ViewGroup>(R.id.activity_container)
        val activityLayout = LayoutInflater.from(activity).inflate(layoutRes, null)

        initDebugPreferences()

        activityContainer.addView(activityLayout)
        activity.setContentView(debugLayout)
    }

    private fun initDebugPreferences() {
        debugLayout.findViewById<Switch>(R.id.sw_mock_responses).apply {
            isChecked = debugPreferences.isMockResponsesEnabled
            setOnCheckedChangeListener { _, isChecked -> debugPreferences.isMockResponsesEnabled = isChecked }
        }
    }

}