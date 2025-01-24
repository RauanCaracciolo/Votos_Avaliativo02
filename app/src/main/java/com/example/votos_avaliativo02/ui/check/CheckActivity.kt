package com.example.votos_avaliativo02.ui.check

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

    }

}