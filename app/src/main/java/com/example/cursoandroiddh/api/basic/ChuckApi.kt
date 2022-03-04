package com.example.cursoandroiddh.api.basic

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ChuckApi {
    @GET("jokes/random")
    fun jokes(): Call<Joke>
}


data class Joke(
    @SerializedName("icon_url")
    val image: String,
    @SerializedName("value")
    val joke: String
)