package com.example.votos_avaliativo02.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.votos_avaliativo02.databinding.ActivityMainBinding
import com.example.votos_avaliativo02.ui.check.CheckActivity
import com.example.votos_avaliativo02.ui.login.LoginActivity
import com.example.votos_avaliativo02.ui.result.ResultActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureListeners()
    }
    fun configureListeners(){
        binding.btnVotar.setOnClickListener{startSelectActivity(1)}
        binding.btnVerMeuVoto.setOnClickListener{startSelectActivity(2)}
        binding.btnVerResultado.setOnClickListener{startSelectActivity(3)}
    }
    fun startSelectActivity(n:Int){
        val mIntent: Intent
        if(n == 1){
            mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)

        }else if(n == 2){
            mIntent = Intent(this, CheckActivity::class.java)
            startActivity(mIntent)
        }
        else if(n==3){
            mIntent = Intent(this, ResultActivity::class.java)
            startActivity(mIntent)
        }


    }
}