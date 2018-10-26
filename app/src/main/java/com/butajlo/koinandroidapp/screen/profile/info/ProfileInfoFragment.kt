package com.butajlo.koinandroidapp.screen.profile.info

import androidx.lifecycle.Observer
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.databinding.TabProfileBinding
import com.butajlo.koinandroidapp.ui.binding
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileInfoFragment : BaseFragment() {

    override val layoutRes = R.layout.tab_profile
    override val fragmentModules = listOf(profileInfoModule)

    private val binding: TabProfileBinding? by binding()
    private val viewModel: ProfileInfoViewModel by viewModel()

    init {
        afterViews {
            viewModel.dataBindingModel.observe(this, Observer { binding?.model = it })
        }
    }
}