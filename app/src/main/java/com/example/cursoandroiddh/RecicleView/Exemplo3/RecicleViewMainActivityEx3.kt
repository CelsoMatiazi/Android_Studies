package com.example.cursoandroiddh.RecicleView.Exemplo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cursoandroiddh.R



class RecicleViewMainActivityEx3 : AppCompatActivity() {

    lateinit var recyclerViewEx3: RecyclerView
    lateinit var adapterEx3: RecyclerViewAdapterEx3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicle_view_main_ex3)

        title = "Shop Car"

        initiComponentsEx3()
    }


    private fun initCarList(): MutableList<CarModel> {

        return mutableListOf(
           CarModel("Ferrari", "488 GT", "https://cdn.carbuzz.com/gallery-images/840x560/341000/300/341322.jpg", "R\$: 2.000.000"),
           CarModel("Ferrari", "Portofino", "https://cdn.motor1.com/images/mgl/Ae27x/s1/ferrari-portofino-m.jpg", "R\$: 1.800.000"),
           CarModel("Mustang", "1967", "https://images.noticiasautomotivas.com.br/img/f/ford-mustang-1967-03-1024x576.jpg", "R\$: 400.000"),
           CarModel("Mustang", "2019", "https://3.bp.blogspot.com/-IfLDOl4asmo/W_3FpKkLDKI/AAAAAAAAMAo/rlYjhLcjHksptBJIgwnE53OsEEiGaE_PQCLcBGAs/s1600/FordMustangGT2019-1.jpg", "R\$: 1.000.000"),
           CarModel("Ferrari", "488 GT", "https://cdn.carbuzz.com/gallery-images/840x560/341000/300/341322.jpg","R\$: 2.000.000"), CarModel("Ferrari", "Portofino", "https://cdn.motor1.com/images/mgl/Ae27x/s1/ferrari-portofino-m.jpg", "R\$: 750.000"),
           CarModel("Mustang", "1967", "https://images.noticiasautomotivas.com.br/img/f/ford-mustang-1967-03-1024x576.jpg", "R\$: 2.000.000"),
           CarModel("Mustang", "2019", "https://3.bp.blogspot.com/-IfLDOl4asmo/W_3FpKkLDKI/AAAAAAAAMAo/rlYjhLcjHksptBJIgwnE53OsEEiGaE_PQCLcBGAs/s1600/FordMustangGT2019-1.jpg", "R\$: 1.000.000"),
        )
    }


    private fun initiComponentsEx3(){

        val cars = initCarList()

        recyclerViewEx3 = findViewById(R.id.recycler_view_ex3)
        adapterEx3 = RecyclerViewAdapterEx3(cars, this)
        recyclerViewEx3?.layoutManager = LinearLayoutManager(this)
        recyclerViewEx3?.adapter = adapterEx3

    }
}