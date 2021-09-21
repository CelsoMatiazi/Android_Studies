package com.example.cursoandroiddh.Fragments.PassandoDados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursoandroiddh.R

class MainActivityPassandoDados : AppCompatActivity() , PDFragmentA.IFragmenteAListener, PDFragmentB.IFragmenteBListener{

    lateinit var fragmentA: PDFragmentA
    lateinit var fragmentB: PDFragmentB



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_passando_dados)

        title = "Passando Dados Fragments"

        initFragments()
    }


    private fun initFragments(){

        fragmentA = PDFragmentA()
        fragmentB = PDFragmentB()

        supportFragmentManager.beginTransaction()
            .add(R.id.pd_fragment_a, fragmentA)
            .add(R.id.pd_fragment_b, fragmentB)
            .commit()
    }

    override fun enviarDadosA(dados: UserData) {
        fragmentB.atualizaDadosB(dados)
    }

    override fun enviarDadosB() {
        TODO("Not yet implemented")
    }

}