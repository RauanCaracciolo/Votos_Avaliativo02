package com.example.votos_avaliativo02.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.votos_avaliativo02.databinding.ActivityResultBinding

class ResultActivity:AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}