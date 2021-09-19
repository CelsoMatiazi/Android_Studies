package com.example.cursoandroiddh.LoginScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cursoandroiddh.R

class LoginScreen1 : AppCompatActivity() {


    lateinit var buttonLogin: Button
    lateinit var nomeLogin: EditText
    lateinit var emailLogin: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen1)

        title = "Login Screen"

        buttonLogin = findViewById(R.id.buttonLogin)
        nomeLogin = findViewById(R.id.userName)
        emailLogin = findViewById(R.id.userEmail)

        buttonLogin.setOnClickListener{

            if(nomeLogin.text.length > 5){

                if(emailLogin.text.contains("@")){
                    val intent = Intent(this, LoginScreen2::class.java)
                    intent.putExtra("nome", nomeLogin.text.toString())
                    intent.putExtra("email", emailLogin.text.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Email Invalido", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "User Name invalido", Toast.LENGTH_LONG).show()
            }


        }
    }
}