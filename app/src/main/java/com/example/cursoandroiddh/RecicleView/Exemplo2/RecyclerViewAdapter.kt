package com.example.cursoandroiddh.RecicleView.Exemplo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter(
    private var users: MutableList<User>,
    private val userView: RecyclerMainActivityEx2
): RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>() {
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_recycler_view_ex2, parent, false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        Picasso.get()
            .load(users[position].imagemUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.imagem))

        holder.nome.text = users[position].nome
    }

    override fun getItemCount(): Int {
        return users.size
    }


    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var imagem: CircleImageView = itemView.findViewById(R.id.item_image_RV_ex2)
        var nome: TextView = itemView.findViewById(R.id.item_nome_RV_ex2)
    }
}



