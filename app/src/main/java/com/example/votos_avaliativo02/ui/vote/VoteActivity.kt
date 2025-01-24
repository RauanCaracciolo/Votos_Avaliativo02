package com.example.votos_avaliativo02.ui.vote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.votos_avaliativo02.databinding.ActivityVoteBinding

class VoteActivity:AppCompatActivity() {
    lateinit var binding: ActivityVoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}