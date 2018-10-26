package com.butajlo.koinandroidapp.ui.tablayout

import com.google.android.material.tabs.TabLayout

fun TabLayout.setLabelsAdapter(adapter: TabLayoutLabelAdapter) {

    for(i in 0 until tabCount) {
        getTabAt(i)?.apply {
            setText(adapter.getTitleRes(i))
            setIcon(adapter.getIconRes(i))
        }
    }

}