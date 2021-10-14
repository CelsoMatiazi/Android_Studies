package com.example.cursoandroiddh.RecicleView.Exemplo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



@SuppressLint("WrongConstant")
class RecicleViewMainActivity : AppCompatActivity() {


    private val recycler by lazy{
        RecyclerView(this)
    }

    private val manager by lazy {
        LinearLayoutManager(this, VERTICAL, false)
        //GridLayoutManager(this,3,VERTICAL,false)
    }

    private val artists = listOf(
        "Mike Stern",
        "Scott Henderson",
        "Paco de Lucia",
        "Miles Davis",
        "Pat Metheny",
        "Jaco Pastorious",
        "Steve Morse",
        "Jimi Hendrix",
        "Hermeto Pascoal",
        "Egberto Gismonti",
        "Eric johnson",
        "Joe Satriani",
        "Steve Vai",
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recicle_view_main)

        title = "RecyclerView"

        setContentView(recycler)

        recycler.layoutManager = manager
        recycler.adapter = AdapterArtists(this, artists)
    }
}