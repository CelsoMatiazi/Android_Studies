package com.example.cursoandroiddh.Fragments.MultFragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursoandroiddh.R

class MainActivityMult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mult)

        title = "Mult Fragments"

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.fragment_a, Fragment_A())
        fragmentTransaction.add(R.id.fragment_b, Fragment_B())
        fragmentTransaction.add(R.id.fragment_c, Fragment_C())

        fragmentTransaction.commit()

    }
}