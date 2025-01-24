package com.example.votos_avaliativo02.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.votos_avaliativo02.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}