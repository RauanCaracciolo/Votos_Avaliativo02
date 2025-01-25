package com.example.votos_avaliativo02.ui.check

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.votos_avaliativo02.data.model.Voto
import com.example.votos_avaliativo02.databinding.ActivityCheckBinding

class CheckActivity:AppCompatActivity() {

    private lateinit var binding: ActivityCheckBinding
    private lateinit var viewModel: CheckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CheckViewModel::class.java)
        configListeners()
    }

    private fun configListeners() {
        binding.btnEntrar.setOnClickListener{getVote()}
    }

    private fun getVote() {
        val cod = binding.etCodigo.text.toString()
        val voto:Voto? = viewModel.getByCode(cod)
        if(voto != null){
            when(voto.valor){
                1->{
                    binding.tvResult.text = "Voce votou em Ruim"
               }
                2->{
                    binding.tvResult.text = "Voce votou em Regular"
                }
                3->{
                    binding.tvResult.text = "Voce votou em Bom"
                }
                4->{
                    binding.tvResult.text = "Voce votou em Otimo"
                }

            }
        }else{
            binding.tvResult.text = "Erro, esse voto nao existe"
        }
    }

}