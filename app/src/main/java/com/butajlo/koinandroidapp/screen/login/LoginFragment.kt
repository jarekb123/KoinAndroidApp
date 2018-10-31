package com.butajlo.koinandroidapp.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.domain.entity.UserEntity
import com.butajlo.koinandroidapp.screen.profile.ProfileFragment
import com.butajlo.koinandroidapp.ui.afterTextChanged
import kotlinx.android.synthetic.main.screen_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    override val layoutRes = R.layout.screen_login

    private val viewModel: LoginViewModel by viewModel()

    init {
        afterViews {
            viewModel.loggedInUser.observe(this, Observer(::loggedInUserChanged))
            btn_login.setOnClickListener(::onLoginClick)
            setupFieldsValidation()
        }
    }

    private fun setupFieldsValidation() {
        et_username.afterTextChanged(viewModel::validateUsername)
        et_password.afterTextChanged(viewModel::validatePassword)

        viewModel.usernameFieldErrorRes.observe(this, Observer { et_username.error = getString(it) })
        viewModel.passwordFieldErrorRes.observe(this, Observer { et_password.error = getString(it) })
    }

    private fun onLoginClick(v: View) {
        viewModel.login(et_username.text.toString(), et_password.text.toString())
    }

    private fun loggedInUserChanged(user: UserEntity?) {
        if (user != null) {
            val arguments = bundleOf(ProfileFragment.KEY_USER_ID to user.id)
            findNavController().navigate(R.id.action_login_to_profile, arguments)
        } else {
            Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show()
        }
    }

}