package com.example.votos_avaliativo02.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.votos_avaliativo02.databinding.ActivityLoginBinding
import com.example.votos_avaliativo02.databinding.ActivityVoteBinding
import com.example.votos_avaliativo02.ui.vote.VoteActivity

class LoginActivity:AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        configListeners()
    }

    private fun configListeners() {

        binding.btnEntrar.setOnClickListener{login()}
    }

    private fun login() {
        val prt = binding.etProntuario.text.toString()
        val nm = binding.etNome.text.toString()
        if(prt.isNotEmpty() && nm.isNotEmpty()){
            if(!viewModel.checkExistence(prt)){
                val mIntent = Intent(this, VoteActivity::class.java)
                mIntent.putExtra("prontuario", prt)
                mIntent.putExtra("nome", nm)
                startActivity(mIntent)
            }else{
                val nome = viewModel.getNome(prt)
                binding.tvResult.text = "Erro no login, $nome você ja votou!"
            }
        }else{
            binding.tvResult.text = "Erro, preencha todos os dados!"
        }

    }

}