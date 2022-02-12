package com.example.cursoandroiddh.architectures.mvp.presenter

import com.example.cursoandroiddh.architectures.mvp.concract.ViewContract
import com.example.cursoandroiddh.architectures.mvp.model.PlacarMVP

class PlacarPresenter {

    lateinit var view : ViewContract

    fun bind(bindView: ViewContract){
        view = bindView
    }

    fun listarPlacar(lista: List<Int>){
        val novaLista = lista.map {
            PlacarMVP(it, PlacarMVP.modify(it))
        }

        view.result(novaLista)

    }
}