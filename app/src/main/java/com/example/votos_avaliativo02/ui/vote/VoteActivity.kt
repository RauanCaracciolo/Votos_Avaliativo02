package com.example.votos_avaliativo02.ui.vote

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.votos_avaliativo02.databinding.ActivityVoteBinding

class VoteActivity:AppCompatActivity() {

    private lateinit var binding: ActivityVoteBinding
    private lateinit var viewModel: VoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(VoteViewModel::class.java)

    }



}