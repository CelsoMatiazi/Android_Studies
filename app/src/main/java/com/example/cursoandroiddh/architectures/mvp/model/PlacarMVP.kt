package com.example.cursoandroiddh.architectures.mvp.model

class PlacarMVP (val original: Int, val modificada: Int){

    companion object{
        fun modify(it: Int): Int {
            if(it % 2 != 0){
                return it +1
            }
            return it
        }
    }
}