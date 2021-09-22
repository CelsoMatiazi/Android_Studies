package com.example.cursoandroiddh.Fragments.LifeCicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cursoandroiddh.R

class MainActivityFragment : AppCompatActivity() {

    private val nameClass = "Teste" + this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        title = "Fragments"

        Log.i(nameClass, "onCreate")
        val fragmentManeger = supportFragmentManager
        val fragmentTransaction = fragmentManeger.beginTransaction()

        fragmentTransaction.add(R.id.container, FragmentView1())
        fragmentTransaction.commit()

    }


    override fun onRestart() {
        super.onRestart()
        Log.i(nameClass, "onRestart")

    }

    override fun onStart() {
        super.onStart()
        Log.i(nameClass, "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i(nameClass, "onResume")
        println("onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.i(nameClass, "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i(nameClass, "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(nameClass, "onDestroy")
    }
}