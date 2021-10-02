package com.example.cursoandroiddh.Fragments.TabBar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.cursoandroiddh.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.ActionBar


class TabBarMainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentAdapter: FragmentAdapter
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_bar_main)

        title = "Artists"
        val bar = supportActionBar
        bar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF3700B3")))


        tabs = findViewById(R.id.tabBar)
        viewPager = findViewById(R.id.pager2)

        fragmentAdapter = FragmentAdapter(this)
        viewPager.adapter = fragmentAdapter

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Artist 1"
                1 -> tab.text = "Artist 2"
                else -> tab.text = "Artist 3"
            }
        }.attach()


    }

    inner class FragmentAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> TabBarFragmentA()
                1 -> TabBarFragmentB()
                else -> TabBarFragmentC()
            }
        }
    }
}