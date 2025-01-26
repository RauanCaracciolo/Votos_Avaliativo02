package com.example.votos_avaliativo02.ui.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.votos_avaliativo02.databinding.ActivityResultBinding

class ResultActivity:AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ResultViewModel::class.java)
        setResults()
    }

    private fun setResults() {
        val ruim = viewModel.count(1)
        val regular = viewModel.count(2)
        val bom = viewModel.count(3)
        val otimo = viewModel.count(4)

        val total = viewModel.getTotal()

        binding.tvResultado01.text = "Ruim: $ruim"
        binding.tvResultado02.text = "Regular: $regular"
        binding.tvResultado03.text = "Bom: $bom"
        binding.tvResultado04.text = "Ótimo: $otimo"

        binding.tvResultadoTotal.text = "Total de Participantes: $total"
    }

}