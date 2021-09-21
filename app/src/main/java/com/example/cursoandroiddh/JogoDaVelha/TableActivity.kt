package com.example.cursoandroiddh.JogoDaVelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.cursoandroiddh.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.util.*


class TableActivity : AppCompatActivity() {

    var matrixTable = mutableListOf<String>("","","","","","","","","")

    lateinit var matrix_0: TextView
    lateinit var matrix_1: TextView
    lateinit var matrix_2: TextView
    lateinit var matrix_3: TextView
    lateinit var matrix_4: TextView
    lateinit var matrix_5: TextView
    lateinit var matrix_6: TextView
    lateinit var matrix_7: TextView
    lateinit var matrix_8: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)



        title = "Jogo da Velha"

        matrix_0 = findViewById(R.id.matrix_0)
        matrix_1 = findViewById(R.id.matrix_1)
        matrix_2 = findViewById(R.id.matrix_2)
        matrix_3 = findViewById(R.id.matrix_3)
        matrix_4 = findViewById(R.id.matrix_4)
        matrix_5 = findViewById(R.id.matrix_5)
        matrix_6 = findViewById(R.id.matrix_6)
        matrix_7 = findViewById(R.id.matrix_7)
        matrix_8 = findViewById(R.id.matrix_8)

        listeners()



    }




    private fun listeners(){

            matrix_0.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_0, 0) }
            matrix_1.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_1, 1) }
            matrix_2.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_2, 2) }
            matrix_3.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_3, 3) }
            matrix_4.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_4, 4) }
            matrix_5.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_5, 5) }
            matrix_6.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_6, 6) }
            matrix_7.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_7, 7) }
            matrix_8.setOnClickListener { if(!endGame() && !win()) markPlay(matrix_8, 8) }

    }

    private fun updateTable(matrix: MutableList<String>){
        matrix_0.text = matrix[0]
        matrix_1.text = matrix[1]
        matrix_2.text = matrix[2]
        matrix_3.text = matrix[3]
        matrix_4.text = matrix[4]
        matrix_5.text = matrix[5]
        matrix_6.text = matrix[6]
        matrix_7.text = matrix[7]
        matrix_8.text = matrix[8]
    }

    private fun markPlay(positionText: TextView, positionMatrix: Int ){

            if(positionText.text.isBlank() ){
                positionText.text = "X"
                matrixTable[positionMatrix] = "X"

                updateTable(matrixTable)

                if(win()){
                    println("Voce venceu")
                    showSnackbar("Voce Venceu!!")
                }else{
                    if(!endGame()){
                        autoPlayer()
                    }

                }
            }

    }


    private fun autoPlayer(){

            val position = (0..8).random()

            if(matrixTable[position].isBlank()){
                matrixTable[position] = "O"

                Timer().schedule(object: TimerTask(){
                            override fun run() {
                                updateTable(matrixTable)
                            }
                }, 1000)



            }else{
                if(!win() && !endGame()){
                    autoPlayer()
                }
            }

            if(win()){
                println("Voce perdeu")
                showSnackbar("Voce Perdeu!!")
            }



    }

    private fun win():Boolean{
        if (comparePosition(0,1,2)) return true
        if (comparePosition(0,3,6)) return true
        if (comparePosition(0,4,8)) return true
        if (comparePosition(1,4,7)) return true
        if (comparePosition(2,5,8)) return true
        if (comparePosition(2,4,6)) return true
        if (comparePosition(3,4,5)) return true
        if (comparePosition(6,7,8)) return true
        return false
    }

    private fun comparePosition(pos1: Int, pos2: Int, pos3: Int): Boolean{

        return if(
            (matrixTable[pos1] == matrixTable[pos2] &&
             matrixTable[pos2] == matrixTable[pos3]) &&
             matrixTable[pos1] != ""){

                changeBackColor(pos1)
                changeBackColor(pos2)
                changeBackColor(pos3)
                true
            }else{
                false
            }

    }

    private fun changeBackColor(a: Int) {
        var color : Int

        if(matrixTable[a] == "X"){
            color = resources.getColor(R.color.green)
        }else{
            color = resources.getColor(R.color.red)
        }

        when(a){
            0 -> matrix_0.setBackgroundColor(color)
            1 -> matrix_1.setBackgroundColor(color)
            2 -> matrix_2.setBackgroundColor(color)
            3 -> matrix_3.setBackgroundColor(color)
            4 -> matrix_4.setBackgroundColor(color)
            5 -> matrix_5.setBackgroundColor(color)
            6 -> matrix_6.setBackgroundColor(color)
            7 -> matrix_7.setBackgroundColor(color)
            8 -> matrix_8.setBackgroundColor(color)
        }

    }


    private fun endGame(): Boolean{
        return !matrixTable.contains("")
    }


    private fun showSnackbar(text: String){
        Snackbar.make(window.decorView.rootView, text, Snackbar.LENGTH_INDEFINITE)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE)
            .setBackgroundTint(Color.parseColor("#006400")).show()
    }


}