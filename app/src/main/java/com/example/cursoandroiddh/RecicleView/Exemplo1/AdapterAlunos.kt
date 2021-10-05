package com.example.cursoandroiddh.RecicleView.Exemplo1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R

class AdapterAlunos(
        val context: Context,
        private val alunos: List<String>
    ): RecyclerView.Adapter<AlunoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
       return AlunoViewHolder(
           LayoutInflater.from(context)
               .inflate(R.layout.recycler_view_ex1, parent, false)
       )
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val nomeAluno: String = alunos[position]
        holder.nome.text = nomeAluno
    }

    override fun getItemCount(): Int {
        return alunos.size
    }


}
