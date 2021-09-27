package com.example.cursoandroiddh.Fragments.PassandoDados3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.cursoandroiddh.R

class FragmentPD3E : Fragment() {

    lateinit var txtContator: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_p_d3_e, container, false)

        txtContator = view.findViewById(R.id.txt_contador)
        view?.isVisible = false
        return view
    }

    fun setValue(num: Int){
        txtContator.text = num.toString()
        view?.isVisible = txtContator.text != "0"
    }

}