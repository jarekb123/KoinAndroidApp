package com.butajlo.koinandroidapp.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.screen.profile.ProfileFragment
import com.butajlo.koinandroidapp.ui.afterTextChanged
import kotlinx.android.synthetic.main.screen_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    override val layoutRes = R.layout.screen_login

    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLogin.observe(this, Observer(::receivedLoginStatus))
        btn_login.setOnClickListener(::onLoginClick)
        setupFieldsValidation()
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

    private fun receivedLoginStatus(isLogin: Boolean) {
        if (isLogin) {

        } else {
            Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show()
        }
    }

}