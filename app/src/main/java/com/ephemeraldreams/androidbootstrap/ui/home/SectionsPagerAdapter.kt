package com.ephemeraldreams.androidbootstrap.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ephemeraldreams.androidbootstrap.ui.feed.PostFragment
import com.ephemeraldreams.androidbootstrap.ui.placeholder.PlaceholderFragment

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            PostFragment.newInstance(1)
        } else {
            PlaceholderFragment.newInstance(position + 1)
        }
    }

    override fun getItemCount(): Int {
        // Show 2 total pages.
        return 2
    }
}
