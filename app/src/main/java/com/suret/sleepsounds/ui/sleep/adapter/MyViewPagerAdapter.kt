package com.suret.sleepsounds.ui.sleep.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(
    parentFragment: Fragment,
) : FragmentStateAdapter(parentFragment) {

    private val fragments = arrayListOf<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment =
        fragments[position]
}