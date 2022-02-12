package com.example.cursoandroiddh.architectures.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cursoandroiddh.architectures.mvvm.model.PlacarMVVM

class PlacarViewModel: ViewModel() {

    private val _lista = MutableLiveData<List<PlacarMVVM>>()
    val lista : LiveData<List<PlacarMVVM>>
        get() = _lista


    fun listar(lista: List<Int>){
        val novaLista = lista.map{ PlacarMVVM(it, PlacarMVVM.modify(it)) }
        _lista.value = novaLista
    }
}
