package com.example.cursoandroiddh.api.full.data.repository

import com.example.cursoandroiddh.api.full.data.ChuckApi3
import com.example.cursoandroiddh.api.full.data.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher


class ChuckRepository(private val api: ChuckApi3 = ChuckApi3.api) {

    fun joke(): Flow<Joke> = flow {
        emit(api.joke())
    }.flowOn(Dispatchers.IO)

    companion object{
        val instance: ChuckRepository by lazy { ChuckRepository() }
    }
}