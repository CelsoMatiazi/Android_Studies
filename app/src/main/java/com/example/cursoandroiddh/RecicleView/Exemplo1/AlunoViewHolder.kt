package com.example.cursoandroiddh.RecicleView.Exemplo1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R

class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
   var nome = view.findViewById<TextView>(R.id.TV_recycle_ex1)
}