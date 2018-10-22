package com.butajlo.koinandroidapp.ui

import android.content.Context

class DebugPreferences(context: Context) {

    private val debugSharedPrefs = context.getSharedPreferences(DEBUG_PREFS, Context.MODE_PRIVATE)

    var isMockResponsesEnabled: Boolean
        get() = debugSharedPrefs.getBoolean(KEY_MOCK_RESPONSES, false)
        set(value) {
            debugSharedPrefs.edit().putBoolean(KEY_MOCK_RESPONSES, value).apply()
        }

    companion object {
        private const val DEBUG_PREFS = "DEBUG_PREFS"
        private const val KEY_MOCK_RESPONSES = "MOCK_RESPONSES"
    }
}