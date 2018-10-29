package com.butajlo.koinandroidapp.ui

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

inline fun <reified T : Any> Fragment.argument(key: String) = lazy { arguments?.get(key) as T }

inline fun <reified T : ViewDataBinding> Fragment.binding() = lazy { view?.let { DataBindingUtil.bind<T>(it) } }
