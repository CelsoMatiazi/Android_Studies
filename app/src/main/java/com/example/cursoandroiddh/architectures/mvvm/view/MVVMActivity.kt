package com.example.cursoandroiddh.architectures.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.architectures.mvc.adapter.PlacarMVCAdapter
import com.example.cursoandroiddh.architectures.mvvm.view.Adapter.PlacarMVVMAdapter
import com.example.cursoandroiddh.architectures.mvvm.viewModel.PlacarViewModel
import kotlin.random.Random

class MVVMActivity : AppCompatActivity(R.layout.activity_mvvmactivity) {

    private val viewModel : PlacarViewModel by viewModels()
    private val values = MutableList(10){
        Random.nextInt(9)
    }

    private val recyclerView : RecyclerView by lazy { findViewById(R.id.architectureMVVM_recycler)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "MVVM"

        viewModel.listar(values)
        observe()


    }

    private fun observe() {
       viewModel.lista.observe(this){
           recyclerView.adapter = PlacarMVVMAdapter(it)
       }
    }
}