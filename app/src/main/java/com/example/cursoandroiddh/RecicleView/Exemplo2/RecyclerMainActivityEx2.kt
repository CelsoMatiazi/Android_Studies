package com.example.cursoandroiddh.RecicleView.Exemplo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R

class RecyclerMainActivityEx2 : AppCompatActivity() {


    lateinit var  recyclerView: RecyclerView
    lateinit var  adapter: RecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_main_ex2)

        title = "Artists"

        initComponents()
    }


    private fun initUsersList(): MutableList<User> {

        return mutableListOf(
            User("Pat Metheny", "https://artesonora.pt/wp-content/uploads/2021/02/pat-metheny.jpg"),
            User("Steve Morse", "https://stevemorse.com/wp-content/uploads/2021/08/Steve-Header-1800x731-1.jpg"),
            User("Paco de Lucia", "https://laparola.com.br/wp-content/uploads/2014/02/paco-de-lucia-AFP-RAFA-RIVAS-900x570.jpg"),
            User("Joe Satriani", "https://ucsfm.com.br/wp-content/uploads/2021/01/SITE-13-01-2021-T-2-1-800x445.png"),
            User("George Benson", "https://www.blackhistorymonth.org.uk/wp-content/uploads/2017/10/Screen-Shot-2017-10-24-at-09.44.28-623x438.png"),
            User("Miles Davis", "https://www.revistabula.com/wp/wp-content/uploads/2018/02/Miles-Davis-610x350.jpg"),
            User("Scott Henderson", "https://www.rockbizz.com.br/wp-content/uploads/2019/08/scott-henderson.jpg"),
            User("Mike Stern", "https://www.baressp.com.br/eventos/fotos/mikestern.jpg"),
            User("Chick Corea", "https://neofeed.com.br/wp-content/uploads/2021/02/ChickCorea.jpeg"),
            User("John Coltrane", "https://concord.com/wp-content/uploads/2021/06/coltranepress.png"),
            User("Alan Holdsworth", "https://s2.glbimg.com/-hJeFn8MWbTOkXnIAfSqt6tsqVc=/0x0:640x360/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2017/7/O/KFsQoBSya8s9dJo9b1XQ/allan-holdsworth-glen-laferman-09-640x360.jpg"),
        )
    }


    private fun initComponents(){
        val users = initUsersList()


        recyclerView = findViewById(R.id.recycler_view_ex2)
        adapter = RecyclerViewAdapter(users, this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter

    }
}