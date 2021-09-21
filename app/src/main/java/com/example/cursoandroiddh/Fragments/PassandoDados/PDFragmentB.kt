package com.example.cursoandroiddh.Fragments.PassandoDados

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cursoandroiddh.R
import java.lang.RuntimeException

class PDFragmentB : Fragment() {

    private lateinit var edtxt_nome: TextView
    private lateinit var edtxt_idade: TextView
    private lateinit var edtxt_email: TextView
    private lateinit var edtxt_senha: TextView
    private lateinit var edtxt_confSenha: TextView
    private var listener: IFragmenteBListener? = null


    interface  IFragmenteBListener{
        fun enviarDadosB()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is IFragmenteBListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "FragmentB nao implementado")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         val view : View = inflater.inflate(R.layout.fragment_p__d___b, container, false)

        edtxt_nome = view.findViewById(R.id.txt_nome)
        edtxt_idade = view.findViewById(R.id.txt_idade)
        edtxt_email = view.findViewById(R.id.txt_email)
        edtxt_senha = view.findViewById(R.id.txt_senha)
        edtxt_confSenha = view.findViewById(R.id.txt_confSenha)


        return view
    }

    fun atualizaDadosB(userData: UserData){
        edtxt_nome.setText(userData.nome)
        edtxt_idade.setText(userData.idade)
        edtxt_email.setText(userData.email)
        edtxt_senha.setText(userData.senha)
        edtxt_confSenha.setText(userData.confSenha)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}