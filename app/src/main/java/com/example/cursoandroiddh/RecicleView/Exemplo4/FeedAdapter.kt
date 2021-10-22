package com.example.cursoandroiddh.RecicleView.Exemplo4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.squareup.picasso.Picasso

class FeedAdapter(val feedList: MutableList<DataFeedModel>):
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_feed_layot_ex4, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        Picasso.get()
            .load(feedList[position].img)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.image))

        holder.nome.text = feedList[position].name
        holder.contentsName.text = feedList[position].name
        holder.numLikes.text = "${feedList[position].numLikes.toString()} curtidas"
        holder.contents.text = feedList[position].contents

    }

    override fun getItemCount(): Int = feedList.size

    inner class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.IV_feed_layout_rvex4)
        var nome : TextView = itemView.findViewById(R.id.rv_name_ex4)
        var contentsName : TextView = itemView.findViewById(R.id.TV_user_rvex4)
        var numLikes : TextView = itemView.findViewById(R.id.TV_curtidas_rvex4)
        var contents : TextView = itemView.findViewById(R.id.TV_descricao_rvex4)
    }
}
