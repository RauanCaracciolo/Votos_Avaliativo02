package com.example.votos_avaliativo02.ui.check

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.votos_avaliativo02.data.model.Voto
import com.example.votos_avaliativo02.data.repository.VotoRepository

class CheckViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: VotoRepository

    private val _votos = MutableLiveData<List<Voto>>()
    val votos: LiveData<List<Voto>> get() = _votos

    init {
        repository = VotoRepository(application)
    }

    // Função para buscar o voto pelo código criado
    fun getByCode(code: String): Voto? {
        return repository.getByCode(code)
    }

}