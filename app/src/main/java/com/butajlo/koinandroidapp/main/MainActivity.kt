package com.butajlo.koinandroidapp.main

import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseActivity
import com.butajlo.koinandroidapp.domain.getUsers
import com.butajlo.koinandroidapp.rx.execute
import org.koin.android.ext.android.get
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

class MainActivity : BaseActivity() {

    override fun layoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindScope(getOrCreateScope("activity_scope"))

        getUsers(get()).execute(
            onSuccess = { Log.d("response", it.toString()) },
            onError = { Log.e("response error", it.toString()) }
        )
    }

    override fun onBackPressed() {
        findNavController(R.id.main_nav_host_fragment).navigateUp()
    }
}
