package com.example.cursoandroiddh.LoginScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cursoandroiddh.R

class LoginScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen2)

        title = "User Screen"

        val textName: TextView = findViewById(R.id.textName)
        val textEmail: TextView = findViewById(R.id.textEmail)

        val intent = intent

        val name = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")

        textName.text = name
        textEmail.text = email
    }
}