package com.example.cursoandroiddh.Animacoes.Exemplo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.cursoandroiddh.R

class AnimMainActivityEx2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_main_ex2)

        title = "Animation 2"
        animation()
    }

    fun animation(){
        val circle = findViewById<ImageView>(R.id.Iv_anim_oval_ex2)
        circle.animate()
            .scaleX(1.1f)
            .scaleY(1.1f)
            .alpha(1f)
            .setDuration(2000)
            .withEndAction {
                circle.scaleX = .9f
                circle.scaleY = .9f
                circle.alpha = .5f
                animation()
            }
    }

}