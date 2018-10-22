package com.butajlo.koinandroidapp.di

import android.app.Activity
import androidx.lifecycle.LifecycleOwner
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.dsl.context.ModuleDefinition
import org.koin.dsl.definition.Definition

inline fun <reified T: Any, A : LifecycleOwner> ModuleDefinition.lifecycleScope(
        lifecycleOwnerClass: Class<A>,
        override: Boolean = false,
        noinline definition: Definition<T>
) = scope(lifecycleOwnerClass.simpleName, override, definition)

fun LifecycleOwner.bindLifecycleScope() {
    bindScope(getOrCreateScope(javaClass.simpleName))
}