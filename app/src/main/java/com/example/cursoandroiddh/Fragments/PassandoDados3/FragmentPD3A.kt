package com.example.cursoandroiddh.Fragments.PassandoDados3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cursoandroiddh.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.RuntimeException

class FragmentPD3A : Fragment() {

    private lateinit var callback: IComunicador
    private lateinit var botaoMais: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is IComunicador){
            callback = context
        }else{
            throw RuntimeException(context.toString() + "Callback não implementado")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_p_d3_a, container, false)

        botaoMais = view.findViewById(R.id.btn_mais)

        botaoMais.setOnClickListener{
            callback.mais()
        }

        return view
    }




}