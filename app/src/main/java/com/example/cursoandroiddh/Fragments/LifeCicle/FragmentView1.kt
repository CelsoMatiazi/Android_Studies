package com.example.cursoandroiddh.Fragments.LifeCicle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cursoandroiddh.R


class FragmentView1 : Fragment() {

    private val nameClass = "Teste" + this.javaClass.name

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(nameClass, "onAttach")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(nameClass, "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i(nameClass, "onCreatedView")
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(nameClass, "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i(nameClass, "onStart")

    }


    override fun onResume() {
        super.onResume()
        Log.i(nameClass, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(nameClass, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(nameClass, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(nameClass, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(nameClass, "onDetach")
    }


}