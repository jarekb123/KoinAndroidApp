package com.butajlo.koinandroidapp.screen.profile.myposts

import androidx.recyclerview.widget.LinearLayoutManager
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.base.BaseFragment
import com.butajlo.koinandroidapp.sharedbindings.CardPostBindingModel
import com.butajlo.koinandroidapp.ui.asObserver
import kotlinx.android.synthetic.main.tab_my_posts.*
import org.koin.android.viewmodel.ext.android.viewModel

class MyPostsFragment : BaseFragment() {
    override val layoutRes = R.layout.tab_my_posts

    private val viewModel by viewModel<MyPostsViewModel>()

    init {
        afterViews {
            setupPostsRecyclerView()
            viewModel.myPosts.observe(this, ::updatePosts.asObserver())
        }
    }

    private fun setupPostsRecyclerView() {
        rv_my_posts.apply {
            adapter = MyPostsAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun updatePosts(posts: List<CardPostBindingModel>) {
        (rv_my_posts.adapter as MyPostsAdapter).setPosts(posts)
    }
}