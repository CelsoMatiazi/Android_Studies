package com.example.cursoandroiddh.Fragments.PassandoDados2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cursoandroiddh.R

class PassDataFragmentB : Fragment() {

    private var contador: Int = 0
    private lateinit var textResult: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_pass_data_b, container, false)
        textResult = view.findViewById(R.id.textResult)

        return view
    }

    fun setResult(valor: Int){

        if(valor == 0){
            contador = 0
        }else{
            contador+=valor
        }
        textResult.text = contador.toString()
    }

}