package com.example.votos_avaliativo02.ui.vote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.votos_avaliativo02.data.model.Voto
import com.example.votos_avaliativo02.data.repository.VotoRepository

class VoteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: VotoRepository

    private val _voto = MutableLiveData<Voto>()
    val voto: LiveData<Voto> get() = _voto

    init {
        repository = VotoRepository(application)
    }

    // Função para inserir o voto no banco
    fun insertVoto(codigo: String, valor: Int): String {

        try {
            var newVoto = Voto(codigo, valor)
            repository.insert(newVoto)

            return "Voto registrado com sucesso! Código: $codigo"
        } catch (e: Exception) {
            e.printStackTrace()

            return "Erro ao registrar voto: ${e.message}"
        }

    }

    // Função para buscar o voto pelo código gerado
    fun getVotoByCode(code: String): Voto? {
        return repository.getByCode(code)
    }

}