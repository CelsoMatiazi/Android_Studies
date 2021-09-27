package com.example.cursoandroiddh.Fragments.PassandoDados2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import com.example.cursoandroiddh.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.RuntimeException

class PassDataFragA : Fragment() {

    private lateinit var callback: IComunicador

    private var contator: Int = 0

    private lateinit var botaoSoma: FloatingActionButton
    private lateinit var botaoSubtrai: FloatingActionButton
    private lateinit var botaoLimpar: FloatingActionButton


    //Recebe o contexto da activity que o fragmento esta conectado
    override fun onAttach(activity: Context) {
        super.onAttach(activity)

        if(activity is IComunicador){
            callback = activity
        }else{
            throw RuntimeException(activity.toString() + "Callback não implementado")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_pass_data_frag_a, container, false)

       botaoSoma = view.findViewById(R.id.sum_button)
       botaoSubtrai = view.findViewById(R.id.sub_button)
       botaoLimpar = view.findViewById(R.id.clear_button)


        botaoSoma.setOnClickListener{
            calcular(1)

        }

        botaoSubtrai.setOnClickListener{
            calcular(-1)

        }

        botaoLimpar.setOnClickListener{
            calcular(0)

        }

        return view
    }

    var value = 0
    fun calcular(num: Int){
        if(num == 0){
            value = 0
            callback.calcular(0)
        }else{
            value+=num
            callback.calcular(value)
        }
        botaoLimpar.isVisible = value != 0
    }

}