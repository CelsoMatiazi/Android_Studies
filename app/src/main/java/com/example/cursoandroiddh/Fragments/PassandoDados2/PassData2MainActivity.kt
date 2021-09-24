package com.example.cursoandroiddh.Fragments.PassandoDados2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursoandroiddh.R

// Sequencia para passar dados por fragmento
//1 - criar fragments e alocar na mainActivity
//2 - criar interface que implementa os metodos necessarios
//3 - main activity implementa a interface

//4 - no fragment EMISSOR criar um callback com tipo da interface
//5 - no onAttach(context: Context) recebe o contexto de quem implementa o fragmento
//6 - no onAttach, teste se o (context is Interface(nome)), se sim callback = context senao throw exception
//7 - no onCreateView atribuir o retorno da view a uma variavel e retornar essa variavel
//8 - no onCreateView obter o id atraves da view.findViewById
//9 - obter o evento de click e associar ao metodo contido na interface por meio do callback

//10 - no fragment RECEPTOR fazer os passos 7, 8
//11 - criar uma função com a regra de negocio
//12 - atribuir o resultado a variavel com o id indicado

class PassData2MainActivity : AppCompatActivity(), IComunicador {

    private lateinit var fragmentA: PassDataFragA
    private lateinit var fragmentB: PassDataFragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_data2_main)

        title = "Contador"

        fragmentA = PassDataFragA()
        fragmentB = PassDataFragmentB()
        supportFragmentManager.beginTransaction()
            .add(R.id.containerA, fragmentA)
            .add(R.id.containerB, fragmentB).commit()
    }

    override fun somar() {
        fragmentB.setResult(1)
    }

    override fun subtrair() {
       fragmentB.setResult(-1)
    }

    override fun clear() {
        fragmentB.setResult(0)
    }
}