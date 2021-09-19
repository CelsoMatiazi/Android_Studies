package com.example.cursoandroiddh.Layouts.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.cursoandroiddh.R

class LinearLayout : AppCompatActivity() {


    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        title = "Linear Layout";

        button1 = findViewById(R.id.button1)
        button1.setOnClickListener{
            Toast.makeText(this,"Press Button 1", Toast.LENGTH_SHORT).show()
        }

        button2 = findViewById(R.id.button2)
        button2.setOnClickListener{
            Toast.makeText(this,"Press Button 2", Toast.LENGTH_SHORT).show()
        }


        button3 = findViewById(R.id.button3)
        button3.setOnClickListener{
            Toast.makeText(this,"Press Button 3", Toast.LENGTH_SHORT).show()
        }

        button4 = findViewById(R.id.button4)
        button4.setOnClickListener{
            Toast.makeText(this,"Press Button 4", Toast.LENGTH_SHORT).show()
        }
    }
}