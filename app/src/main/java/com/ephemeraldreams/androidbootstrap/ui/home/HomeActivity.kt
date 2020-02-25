package com.ephemeraldreams.androidbootstrap.ui.home

import android.os.Bundle
import android.widget.Toast
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.databinding.ActivityHomeBinding
import com.ephemeraldreams.androidbootstrap.ui.feed.PostFragment
import com.ephemeraldreams.androidbootstrap.ui.feed.dummy.DummyContent
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity(), PostFragment.OnListFragmentInteractionListener {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = SectionsPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { currentTab, currentPosition ->
            currentTab.text = this.resources.getString(TAB_TITLES[currentPosition])
        }.attach()

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }
}
