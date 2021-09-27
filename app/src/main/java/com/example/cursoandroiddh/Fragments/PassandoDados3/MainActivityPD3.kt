package com.example.cursoandroiddh.Fragments.PassandoDados3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursoandroiddh.R

class MainActivityPD3 : AppCompatActivity(), IComunicador {

    private lateinit var fragmentA: FragmentPD3A
    private lateinit var fragmentB: FragmentPD3B
    private lateinit var fragmentC: FragmentPD3C
    private lateinit var fragmentD: FragmentPD3D
    private lateinit var fragmentE: FragmentPD3E


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pd3)

        title = "Comunicação Multipla"

        fragmentA = FragmentPD3A()
        fragmentB = FragmentPD3B()
        fragmentC = FragmentPD3C()
        fragmentD = FragmentPD3D()
        fragmentE = FragmentPD3E()

        intiFragments()
    }


    fun intiFragments(){
        supportFragmentManager.beginTransaction()
            .add(R.id.containerA, fragmentA)
            .add(R.id.containerB, fragmentB)
            .add(R.id.containerC, fragmentC)
            .add(R.id.containerD, fragmentD)
            .add(R.id.containerE, fragmentE).commit()

    }

    var clicks = 0
    var contador = 0
    override fun mais() {
        clicks += 1
        contador += 1
        fragmentC.showButton(contador)
        fragmentD.setValue(clicks)
        fragmentE.setValue(contador)

    }

    override fun menos() {
        clicks += 1
        contador -= 1
        fragmentC.showButton(contador)
        fragmentD.setValue(clicks)
        fragmentE.setValue(contador)
    }

    override fun zerar() {
        clicks += 1
        contador = 0
        fragmentC.showButton(0)
        fragmentD.setValue(clicks)
        fragmentE.setValue(contador)
    }

}