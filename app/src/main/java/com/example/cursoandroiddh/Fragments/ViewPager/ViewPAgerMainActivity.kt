package com.example.cursoandroiddh.Fragments.ViewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.cursoandroiddh.R


private const val NUM_PAGES = 5

class ViewPAgerMainActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_main)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager)


        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = PageAdapter(this)
        viewPager.adapter = pagerAdapter
    }



    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class PageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> ViewPagerFragmentA()
                1 -> ViewPagerFragmentB()
                2 -> ViewPagerFragmentA()
                3 -> ViewPagerFragmentA()
                else -> ViewPagerFragmentA()
            }
        }
    }
}