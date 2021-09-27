package com.example.cursoandroiddh.Fragments.PassandoDados

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.cursoandroiddh.R
import java.lang.RuntimeException


class PDFragmentA : Fragment() {


    private lateinit var button: Button
    private lateinit var edtxt_nome: EditText
    private lateinit var edtxt_idade: EditText
    private lateinit var edtxt_email: EditText
    private lateinit var edtxt_senha: EditText
    private lateinit var edtxt_confSenha: EditText
    private var listener: IFragmenteAListener? = null


    private lateinit var userData: UserData


    interface IFragmenteAListener{
        fun enviarDadosA(dados: UserData){

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is IFragmenteAListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "FragmentListener não implementado")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_p__d___a, container, false)

        button = view.findViewById(R.id.buttonEnviar)
        edtxt_nome = view.findViewById(R.id.pd_nome)
        edtxt_idade = view.findViewById(R.id.pd_idade)
        edtxt_email = view.findViewById(R.id.pd_email)
        edtxt_senha = view.findViewById(R.id.pd_senha)
        edtxt_confSenha = view.findViewById(R.id.pd_conf_senha)


        userData = UserData(
            edtxt_nome.text.toString(),
            edtxt_idade.text.toString(),
            edtxt_email.text.toString(),
            edtxt_senha.text.toString(),
            edtxt_confSenha.text.toString()
        )


        button.setOnClickListener{
            userData = UserData(
                edtxt_nome.text.toString(),
                edtxt_idade.text.toString(),
                edtxt_email.text.toString(),
                edtxt_senha.text.toString(),
                edtxt_confSenha.text.toString()
            )

            listener?.enviarDadosA(userData)

            edtxt_nome.setText(" ")
            edtxt_idade.setText(" ")
            edtxt_email.setText(" ")
            edtxt_senha.setText(" ")
            edtxt_confSenha.setText(" ")
        }

        return view
    }





    override fun onDetach() {
        super.onDetach()
        listener = null
    }


}