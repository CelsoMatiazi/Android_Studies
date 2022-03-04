package com.example.cursoandroiddh.api.full

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cursoandroiddh.api.full.data.Joke
import com.example.cursoandroiddh.api.full.data.repository.ChuckRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FullChuckViewModel(private val repository: ChuckRepository = ChuckRepository.instance): ViewModel() {

    private val _error: MutableLiveData<Boolean> = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    private val _success: MutableLiveData<Joke> = MutableLiveData()
    val success: LiveData<Joke>
        get() = _success


    fun joke() = viewModelScope.launch{

        repository
            .joke()
            .catch {  _error.value = true }
            .collect {  _success.value = it }


    }
}