package com.butajlo.koinandroidapp.screen.profile

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.ui.argument
import com.butajlo.koinandroidapp.ui.tablayout.setLabelsAdapter
import kotlinx.android.synthetic.main.screen_profile.*
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment() {

    override val layoutRes = R.layout.screen_profile

    private val userId by argument<Long>(KEY_USER_ID)
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // first run of the fragment, this will not execute after configuration change, eg. screen orientation
        if (savedInstanceState == null) {
            // If user is logged in -> bind Koin scope with scoped SessionManager
            bindScope(getOrCreateScope("user_session"))
            viewModel.login(userId)
        }
    }

    init {
        afterViews {
            context?.let {
                fragmentManager?.let {
                    val adapter = TabAdapter(it)
                    vp_tabs.adapter = adapter
                    tl_tabs.setupWithViewPager(vp_tabs)
                    tl_tabs.setLabelsAdapter(adapter)
                }
            }
            findNavController().popBackStack()
        }
    }

    companion object {
        const val KEY_USER_ID = "ProfileFragment.KEY_USER_ID"
    }
}