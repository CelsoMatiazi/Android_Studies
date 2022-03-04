package com.example.cursoandroiddh.api.full.data




import com.example.cursoandroiddh.api.medium.data.RetrofitFactory
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface ChuckApi3 {
    @GET("jokes/random")
    suspend fun joke(): Joke

    companion object{
        val api : ChuckApi3 by lazy {
            RetrofitFactory
                .build("https://api.chucknorris.io/")
                .create(ChuckApi3::class.java)
        }

    }
}


data class Joke(
    @SerializedName("icon_url")
    val image: String,
    @SerializedName("value")
    val joke: String
)
