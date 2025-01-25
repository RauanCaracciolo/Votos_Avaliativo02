package com.example.votos_avaliativo02.ui.vote

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.votos_avaliativo02.R
import com.example.votos_avaliativo02.databinding.ActivityMainBinding
import com.example.votos_avaliativo02.databinding.ActivityVoteBinding
import com.example.votos_avaliativo02.ui.main.MainActivity

class VoteActivity:AppCompatActivity() {

    private lateinit var binding: ActivityVoteBinding
    private lateinit var viewModel: VoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o layout
        binding = ActivityVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(VoteViewModel::class.java)
        configListeners()
    }

    private fun openBundle() {

    }

    private fun configListeners() {
        val ptr = intent.getStringExtra("prontuario")
        val nm = intent.getStringExtra("nome")
        var escl:Int? = null

        binding.btnVotar.setOnClickListener{
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.rbRuim ->{
                    escl = 1
                }
                R.id.rbRegular ->{
                    escl = 2
                }
                R.id.rbBom->{
                    escl = 3
                }
                R.id.rbOtimo ->{
                    escl = 4
                }
            }
            Toast.makeText(this, escl.toString(), Toast.LENGTH_SHORT).show()
            if (ptr != null && nm != null && escl != null) {
                viewModel.login(ptr, nm)
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val rtn = viewModel.insertVoto(escl!!)
                val clip = ClipData.newPlainText("label", rtn)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this, "Codigo copiado para area de transferecia", Toast.LENGTH_SHORT).show()
                val mIntent = Intent(this, MainActivity::class.java)
                startActivity(mIntent)
            }else{
                binding.tvResult.text = "Erro, escolha uma opcao!"
            }
        }
    }


}