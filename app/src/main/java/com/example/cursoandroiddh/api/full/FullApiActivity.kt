package com.example.cursoandroiddh.api.full

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.api.medium.ChuckViewModel

import com.squareup.picasso.Picasso

class FullApiActivity : AppCompatActivity(R.layout.activity_basic_api) {

    private val chuckViewModel : ChuckViewModel by viewModels()

    private val basicApiText: TextView by lazy { findViewById(R.id.basicApi_body) }
    private val basicApiBtn: Button by lazy { findViewById(R.id.basicApi_btn) }
    private val basicApiImg: ImageView by lazy { findViewById(R.id.basicApi_img) }
    private val basicApiProgBar: ProgressBar by lazy { findViewById(R.id.basicApi_progBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Chuck FullApi"

        request()
        observer()

        basicApiBtn.setOnClickListener {
            basicApiProgBar.isVisible = true
            request()
        }

    }

    private fun request(){
        chuckViewModel.joke()
    }

    private fun observer(){
        chuckViewModel.error.observe(this){
            if(it){
                Toast.makeText(this, "Falha na conexão", Toast.LENGTH_LONG).show()
            }
        }

        chuckViewModel.success.observe(this){
            Picasso.get().load(it.image).into((basicApiImg))
            basicApiText.text = it.joke
            basicApiProgBar.isVisible = false
        }
    }
}