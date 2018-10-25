package com.butajlo.koinandroidapp.screen.profile

import android.os.Bundle
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.network.sessionModule
import com.butajlo.koinandroidapp.ui.argument
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.standalone.StandAloneContext.loadKoinModules

class ProfileFragment : BaseFragment() {
    override val layoutRes = R.layout.screen_profile

    private val userId by argument<Long>(KEY_USER_ID)
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(sessionModule)

        // first run
        if (savedInstanceState == null) {
            viewModel.login(userId)
        }
    }

    companion object {
        const val KEY_USER_ID = "ProfileFragment.KEY_USER_ID"
    }
}