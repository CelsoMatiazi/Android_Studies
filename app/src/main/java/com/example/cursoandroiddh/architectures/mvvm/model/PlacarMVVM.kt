package com.example.cursoandroiddh.architectures.mvvm.model

class PlacarMVVM (val original: Int, val modificada: Int){

    companion object{
        fun modify(it: Int): Int {
            if(it % 2 != 0){
                return it +1
            }
            return it
        }
    }
}