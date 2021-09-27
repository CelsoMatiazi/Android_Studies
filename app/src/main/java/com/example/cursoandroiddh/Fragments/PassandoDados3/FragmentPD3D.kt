package com.example.cursoandroiddh.Fragments.PassandoDados3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.cursoandroiddh.R

class FragmentPD3D : Fragment() {

    private lateinit var textClicks: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_p_d3_d, container, false)
        textClicks = view.findViewById(R.id.txt_clicks)
        view?.isVisible = false

        return view
    }

    fun setValue(num: Int){
        textClicks.text = num.toString()
        view?.isVisible = num != 0
    }


}