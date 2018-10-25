package com.butajlo.koinandroidapp.ui

import androidx.fragment.app.Fragment

inline fun <reified T : Any> Fragment.argument(key: String) = lazy { arguments?.get(key) as T }