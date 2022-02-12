package com.example.cursoandroiddh.architectures.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.architectures.mvc.adapter.PlacarMVCAdapter
import com.example.cursoandroiddh.architectures.mvc.model.PlacarMCV
import kotlin.random.Random

class MVCActivity : AppCompatActivity(R.layout.activity_mvcactivity) {

    private val values = MutableList(10){
        Random.nextInt(9)
    }

    private val recyclerView :RecyclerView by lazy { findViewById(R.id.architecture_recycler)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="MVC"

        val placar = map(values)

        recyclerView.adapter = PlacarMVCAdapter(placar)

    }

    private fun map(dados: List<Int>): List<PlacarMCV>{
        return dados.map {
            PlacarMCV(it, PlacarMCV.modify(it))
        }
    }

}