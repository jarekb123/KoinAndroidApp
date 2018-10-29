package com.butajlo.koinandroidapp.screen.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.butajlo.koinandroidapp.R
import com.butajlo.koinandroidapp.screen.profile.info.ProfileInfoFragment
import com.butajlo.koinandroidapp.ui.tablayout.TabLayoutLabelAdapter

class TabAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm), TabLayoutLabelAdapter {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ProfileInfoFragment()
            else -> Fragment()
        }
    }

    override fun getCount() = 2

    override fun getTitleRes(position: Int): Int {
        return when(position) {
            0 -> R.string.profile_tab_title
            1 -> R.string.articles_tab_title
            else -> -1
        }
    }

    override fun getIconRes(position: Int): Int {
        return when(position) {
            0 -> R.drawable.ic_person_50dp
            1 -> R.drawable.ic_articles
            else -> -1
        }
    }
}