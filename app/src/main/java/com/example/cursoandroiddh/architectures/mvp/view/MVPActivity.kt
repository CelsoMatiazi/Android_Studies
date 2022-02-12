package com.example.cursoandroiddh.architectures.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.architectures.mvp.concract.ViewContract
import com.example.cursoandroiddh.architectures.mvp.view.adapter.PlacarMVPAdapter
import com.example.cursoandroiddh.architectures.mvp.model.PlacarMVP
import com.example.cursoandroiddh.architectures.mvp.presenter.PlacarPresenter
import kotlin.random.Random

class MVPActivity : AppCompatActivity(R.layout.activity_mvpactivity), ViewContract {

    private val presenter = PlacarPresenter()
    private val values = MutableList(10){
        Random.nextInt(9)
    }

    private val recyclerView : RecyclerView by lazy { findViewById(R.id.architectureMVP_recycler)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="MVP"

        presenter.bind(this)
        presenter.listarPlacar(values)

    }

    override fun result(dados: List<PlacarMVP>) {
       recyclerView.adapter = PlacarMVPAdapter(dados)
    }
}