package com.example.cursoandroiddh.api.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.cursoandroiddh.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BasicApiActivity : AppCompatActivity() {

    private val basicApiText: TextView by lazy { findViewById(R.id.basicApi_body) }
    private val basicApiBtn: Button by lazy { findViewById(R.id.basicApi_btn) }
    private val basicApiImg: ImageView by lazy { findViewById(R.id.basicApi_img) }
    private val basicApiProgBar: ProgressBar by lazy { findViewById(R.id.basicApi_progBar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_api)
        title = "Chuck Norris Jokes"


        newJoke()

        basicApiBtn.setOnClickListener {
            newJoke()
        }


    }


    private fun newJoke(){

        basicApiProgBar.isVisible = true

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.chucknorris.io/")
            .build()

        val api: ChuckApi = retrofit.create(ChuckApi::class.java)

        api.jokes().enqueue(object : Callback<Joke>{

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                response.errorBody()?.let {
                    Toast.makeText(this@BasicApiActivity, "retorno de erro do servidor", Toast.LENGTH_SHORT).show()
                }

                response.body()?.let {

                    Picasso.get().load(it.image).into((basicApiImg))
                    basicApiText.text = it.joke
                    basicApiProgBar.isVisible = false
                    //Toast.makeText(this@BasicApiActivity, "Sucesso!!!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Toast.makeText(applicationContext, "Falha no envio", Toast.LENGTH_SHORT).show()
            }

        })

    }

}