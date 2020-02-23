package com.ephemeraldreams.androidbootstrap.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.ui.feed.PostFragment
import com.ephemeraldreams.androidbootstrap.ui.feed.dummy.DummyContent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity(), PostFragment.OnListFragmentInteractionListener {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager) { currentTab, currentPosition ->
            currentTab.text = this.resources.getString(TAB_TITLES[currentPosition])
        }.attach()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }
}
