package com.example.cursoandroiddh.CicloDeVidaActiv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cursoandroiddh.R

class LifeCiclePage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cicle_page2)

        title = "Second Screen"

        val button = findViewById<Button>(R.id.lifeCicle_btn_pg2)
        button.setOnClickListener{
            onBackPressed()
            //finish()
        }
    }
}