package com.example.cursoandroiddh.RecicleView.Exemplo1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R



class AdapterArtists(
        val context: Context,
        private val artists: List<String>
    ): RecyclerView.Adapter<ArtistViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
       return ArtistViewHolder(
           LayoutInflater.from(context)
               .inflate(R.layout.recycler_view_ex1, parent, false)
       )
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artistName: String = artists[position]
        holder.nome.text = artistName
    }

    override fun getItemCount(): Int {
        return artists.size
    }

}
