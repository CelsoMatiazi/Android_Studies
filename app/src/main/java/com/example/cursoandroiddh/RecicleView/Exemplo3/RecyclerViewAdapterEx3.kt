package com.example.cursoandroiddh.RecicleView.Exemplo3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.squareup.picasso.Picasso


class RecyclerViewAdapterEx3(
    private var cars: MutableList<CarModel>,
    private val carView: RecicleViewMainActivityEx3
): RecyclerView.Adapter<RecyclerViewAdapterEx3.CarViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_ex3, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        Picasso.get()
            .load(cars[position].imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.imagem))

        holder.marca.text = cars[position].marca
        holder.modelo.text = cars[position].modelo
        holder.valor.text = cars[position].valor

    }

    override fun getItemCount(): Int {
        return cars.size
    }


    class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imagem: ImageView = itemView.findViewById(R.id.IV_ex3_image)
        var marca: TextView = itemView.findViewById(R.id.TV_ex3_marca)
        var modelo: TextView = itemView.findViewById(R.id.TV_ex3_modelo)
        var valor: TextView = itemView.findViewById(R.id.TV_ex3_valor)
    }
}
