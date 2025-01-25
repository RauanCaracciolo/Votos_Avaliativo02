package com.example.votos_avaliativo02.ui.vote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.votos_avaliativo02.data.model.User
import com.example.votos_avaliativo02.data.model.Voto
import com.example.votos_avaliativo02.data.model.Voto.Companion.generateRandomCode
import com.example.votos_avaliativo02.data.repository.UserRepository
import com.example.votos_avaliativo02.data.repository.VotoRepository

class VoteViewModel(application: Application) : AndroidViewModel(application) {

    private var voteRepository: VotoRepository
    private var userRepository: UserRepository

    private val _voto = MutableLiveData<Voto>()
    val voto: LiveData<Voto> get() = _voto

    init {
        voteRepository = VotoRepository(application)
        userRepository = UserRepository(application)
    }

    // Função para inserir o voto no banco
    fun insertVoto(valor: Int): String? {

        try {
            val codigo = generateRandomCode()
            val newVoto = Voto(codigo, valor)
            voteRepository.insert(newVoto)

            return codigo
        } catch (e: Exception) {
            e.printStackTrace()

            return "Erro no registro de voto."
        }

    }
    // Função para e registrar o usuário
    fun login(prontuario: String, nome: String): Boolean {

        try {
            if (nome.isNotEmpty()) {
                val newUser = User(prontuario, nome)
                userRepository.insert(newUser)
                    return true
                } else {
                    return false
                }
            }
        catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
    // Função para buscar o voto pelo código gerado
    fun getVotoByCode(code: String): Voto? {
        return voteRepository.getByCode(code)
    }

}