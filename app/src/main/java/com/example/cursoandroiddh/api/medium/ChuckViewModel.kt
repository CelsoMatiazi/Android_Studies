package com.example.cursoandroiddh.api.medium


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChuckViewModel: ViewModel() {

    private val _error: MutableLiveData<Boolean> = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    private val _success: MutableLiveData<Joke> = MutableLiveData()
    val success: LiveData<Joke>
        get() = _success


    fun joke(){
            ChuckApi2.api.jokes().enqueue(object : Callback<Joke> {

                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    response.errorBody()?.let {
                       _error.value = true
                    }

                    response.body()?.let {
                        _success.value = it
                    }
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    _error.value = true
                }

            })
    }


}