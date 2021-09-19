package com.example.cursoandroiddh.CicloDeVidaActiv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.cursoandroiddh.R

class LifeCiclePage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cicle_page1)

        title = "Life Cicle"

        val button = findViewById<Button>(R.id.lifeCicle_btn_pg1)
        button.setOnClickListener {
            val intent = Intent(this, LifeCiclePage2::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Teste", "onRestart")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.i("Teste", "onStart")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("Teste", "onResume")
        println("onResume")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("Teste", "onPause")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("Teste", "onStop")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Teste", "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}