package com.example.cursoandroiddh.api.medium

import com.example.cursoandroiddh.api.medium.data.RetrofitFactory
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ChuckApi2 {
    @GET("jokes/random")
    fun jokes(): Call<Joke>


    companion object{
        val api : ChuckApi2 by lazy {
            RetrofitFactory
            .build("https://api.chucknorris.io/")
            .create(ChuckApi2::class.java)
        }

    }
}


data class Joke(
    @SerializedName("icon_url")
    val image: String,
    @SerializedName("value")
    val joke: String
)