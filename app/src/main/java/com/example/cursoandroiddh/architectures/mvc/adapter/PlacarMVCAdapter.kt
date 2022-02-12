package com.example.cursoandroiddh.architectures.mvc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.architectures.mvc.model.PlacarMCV

class PlacarMVCAdapter(private val dados: List<PlacarMCV>): RecyclerView.Adapter<PlacarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacarViewHolder {
       val inflater = LayoutInflater.from(parent.context)

        return PlacarViewHolder(inflater.inflate(R.layout.item_placar_layout, parent, false))
    }

    override fun onBindViewHolder(holder: PlacarViewHolder, position: Int) {
        holder.bind(dados[position])
    }

    override fun getItemCount(): Int = dados.size
}

class PlacarViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val originalView: TextView = view.findViewById(R.id.item_original)
    private val modificadoView: TextView = view.findViewById(R.id.item_modificado)
    fun bind(dado: PlacarMCV){
        originalView.text = dado.original.toString()
        modificadoView.text = dado.modificada.toString()
    }
}