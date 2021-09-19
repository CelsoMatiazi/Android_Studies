package com.example.cursoandroiddh.Fragments.BottonNav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cursoandroiddh.CicloDeVidaActiv.LifeCiclePage2
import com.example.cursoandroiddh.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivityBtnNav : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var gamesFragment: GamesFragment
    private lateinit var consolesFragment: ConsolesFragment

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_btn_nav)

        title = "Fragments"

        homeFragment = HomeFragment()
        consolesFragment = ConsolesFragment()
        gamesFragment = GamesFragment()

        setFragment(homeFragment)

        bottomNavigationView = findViewById(R.id.bottom_navigation)


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> setFragment(homeFragment)
                R.id.menu_game -> setFragment(gamesFragment)
                R.id.menu_console -> setFragment(consolesFragment)
                R.id.menu_Help -> openActivity()
            }
            true
        }

    }


    private fun setFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()
    }

    private fun openActivity(){
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)
    }


}