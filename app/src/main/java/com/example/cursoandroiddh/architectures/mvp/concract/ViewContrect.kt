package com.example.cursoandroiddh.architectures.mvp.concract

import com.example.cursoandroiddh.architectures.mvp.model.PlacarMVP
import com.example.cursoandroiddh.architectures.mvp.view.MVPActivity

interface ViewContract {
    fun result(dados: List<PlacarMVP>)
}
