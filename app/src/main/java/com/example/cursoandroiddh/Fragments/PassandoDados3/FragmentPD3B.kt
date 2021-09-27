package com.example.cursoandroiddh.Fragments.PassandoDados3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cursoandroiddh.R
import java.lang.RuntimeException

class FragmentPD3B : Fragment() {

    private lateinit var callback: IComunicador
    private lateinit var botaoMenos: Button


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
        var view = inflater.inflate(R.layout.fragment_p_d3_b, container, false)

        botaoMenos = view.findViewById(R.id.btn_menos)

        botaoMenos.setOnClickListener{
            callback.menos()
        }

        return view
    }




}