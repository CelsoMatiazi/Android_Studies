package com.example.cursoandroiddh.RecicleView.Exemplo4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.squareup.picasso.Picasso

class StoriesAdapter(val stories: MutableList<DataStoriesModel>): RecyclerView.Adapter<StoriesAdapter.StoreiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_stories_ex4, parent, false)
        return StoreiesViewHolder(view)
    }

    override fun getItemCount(): Int = stories.size

    override fun onBindViewHolder(holder: StoreiesViewHolder, position: Int) {
        Picasso.get()
            .load(stories[position].img)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.image))

        holder.nome.text = stories[position].name
    }


    inner class StoreiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.IV_stories_RV_Ex4)
        var nome : TextView = itemView.findViewById(R.id.TV_stories_RV_Ex4)
    }
}
