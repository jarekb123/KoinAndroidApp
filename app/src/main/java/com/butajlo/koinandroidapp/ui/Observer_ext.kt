package com.butajlo.koinandroidapp.ui

import androidx.lifecycle.Observer

fun <T> ((T) -> Unit).asObserver() = Observer<T> { this(it) }