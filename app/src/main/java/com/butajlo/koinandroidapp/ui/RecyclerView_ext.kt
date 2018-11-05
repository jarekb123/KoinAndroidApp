package com.butajlo.koinandroidapp.ui

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

fun <T : ViewDataBinding> RecyclerView.ViewHolder.binding() = lazy { itemView.let { DataBindingUtil.bind<T>(it) } }