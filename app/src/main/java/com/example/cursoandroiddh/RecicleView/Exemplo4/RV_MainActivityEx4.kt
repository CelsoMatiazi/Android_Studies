package com.example.cursoandroiddh.RecicleView.Exemplo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R
import com.example.cursoandroiddh.RecicleView.Exemplo2.User

class RV_MainActivityEx4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_main_ex4)

        title ="InstaMusic"


        val recyclerViewStories = findViewById<RecyclerView>(R.id.RV_stories_Ex4)
        val recyclerViewFeed = findViewById<RecyclerView>(R.id.RV_feed_Ex4)

        recyclerViewStories.adapter = StoriesAdapter(initStoriesList())
        recyclerViewStories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewFeed.adapter = FeedAdapter(initFeedList())
        recyclerViewFeed.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }



    private fun initStoriesList(): MutableList<DataStoriesModel> {
        return mutableListOf(
            DataStoriesModel("Pat Metheny", "https://artesonora.pt/wp-content/uploads/2021/02/pat-metheny.jpg"),
            DataStoriesModel("Steve Morse", "https://stevemorse.com/wp-content/uploads/2021/08/Steve-Header-1800x731-1.jpg"),
            DataStoriesModel("Paco de Lucia", "https://laparola.com.br/wp-content/uploads/2014/02/paco-de-lucia-AFP-RAFA-RIVAS-900x570.jpg"),
            DataStoriesModel("Joe Satriani", "https://ucsfm.com.br/wp-content/uploads/2021/01/SITE-13-01-2021-T-2-1-800x445.png"),
            DataStoriesModel("George Benson", "https://www.blackhistorymonth.org.uk/wp-content/uploads/2017/10/Screen-Shot-2017-10-24-at-09.44.28-623x438.png"),
            DataStoriesModel("Miles Davis", "https://www.revistabula.com/wp/wp-content/uploads/2018/02/Miles-Davis-610x350.jpg"),
            DataStoriesModel("Scott Henderson", "https://www.rockbizz.com.br/wp-content/uploads/2019/08/scott-henderson.jpg"),
            DataStoriesModel("Mike Stern", "https://www.baressp.com.br/eventos/fotos/mikestern.jpg"),
            DataStoriesModel("Chick Corea", "https://neofeed.com.br/wp-content/uploads/2021/02/ChickCorea.jpeg"),
            DataStoriesModel("John Coltrane", "https://concord.com/wp-content/uploads/2021/06/coltranepress.png"),
            DataStoriesModel("Alan Holdsworth", "https://s2.glbimg.com/-hJeFn8MWbTOkXnIAfSqt6tsqVc=/0x0:640x360/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2017/7/O/KFsQoBSya8s9dJo9b1XQ/allan-holdsworth-glen-laferman-09-640x360.jpg"),
        )
    }


    private fun initFeedList(): MutableList<DataFeedModel>{
        return mutableListOf(
            DataFeedModel("Celso Ricardi", "https://is4-ssl.mzstatic.com/image/thumb/Music69/v4/5e/31/8f/5e318f52-7183-2084-afe5-16a1e4f761f8/cover.jpg/486x486bb.png",45, "Electric City - 989 records"),
            DataFeedModel("Celso Ricardi", "https://img.discogs.com/SnQr99cgEwTA3VywM6SsuwuQWds=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-6276108-1415382972-5795.jpeg.jpg",65, "A Better Future - 989 records"),
            DataFeedModel("SexDog", "https://skycms.s3.amazonaws.com/images/5495100/cachorro-card-2.png",87, "Uma noite só, as vezes faz bem"),
            DataFeedModel("SexDog", "https://thumbs.dreamstime.com/b/sal%C3%A3o-de-beleza-do-bem-estar-dos-termas-c%C3%A3o-111713662.jpg",234, "I'm so Sexy.."),
            DataFeedModel("Big Bang Theory", "https://blogs.correiobraziliense.com.br/proximocapitulo/wp-content/uploads/sites/27/2019/06/document%C3%A1rio-de-the-big-bang-theory-1-1280x720.jpg",65, "This is Big Bang Theory"),
            DataFeedModel("Jimi Hendrix", "https://rollingstone.uol.com.br/media/uploads/jimi-hendrix-bruce_fleming-ap_images.jpg",2398, "I'm Black and White"),
            DataFeedModel("Jimi Hendrix", "https://topview.com.br/wp-content/uploads/2017/07/Fatos-e-curiosidades-sobre-Jimi-Hendrix-os.png",425, "Jimi Cartoon"),
            DataFeedModel("Celso Ricardi", "https://is4-ssl.mzstatic.com/image/thumb/Music69/v4/5e/31/8f/5e318f52-7183-2084-afe5-16a1e4f761f8/cover.jpg/486x486bb.png",45, "Electric City - 989 records"),
            DataFeedModel("Celso Ricardi", "https://img.discogs.com/SnQr99cgEwTA3VywM6SsuwuQWds=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-6276108-1415382972-5795.jpeg.jpg",65, "A Better Future - 989 records"),
            DataFeedModel("SexDog", "https://skycms.s3.amazonaws.com/images/5495100/cachorro-card-2.png",87, "Uma noite só, as vezes faz bem"),
            DataFeedModel("SexDog", "https://thumbs.dreamstime.com/b/sal%C3%A3o-de-beleza-do-bem-estar-dos-termas-c%C3%A3o-111713662.jpg",234, "I'm so Sexy.."),
            DataFeedModel("Big Bang Theory", "https://blogs.correiobraziliense.com.br/proximocapitulo/wp-content/uploads/sites/27/2019/06/document%C3%A1rio-de-the-big-bang-theory-1-1280x720.jpg",65, "This is Big Bang Theory"),
            DataFeedModel("Jimi Hendrix", "https://rollingstone.uol.com.br/media/uploads/jimi-hendrix-bruce_fleming-ap_images.jpg",2398, "I'm Black and White"),
            DataFeedModel("Jimi Hendrix", "https://topview.com.br/wp-content/uploads/2017/07/Fatos-e-curiosidades-sobre-Jimi-Hendrix-os.png",425, "Jimi Cartoon"),

        )
    }

}