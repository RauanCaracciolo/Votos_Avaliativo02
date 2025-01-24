package com.example.votos_avaliativo02.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.votos_avaliativo02.data.model.User
import com.example.votos_avaliativo02.data.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserRepository

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    init {
        repository = UserRepository(application)
    }

    // Função para efetuar o login ou registrar o usuário e logar
    fun login(prontuario: String, nome: String): String {

        try {
            val existingUser = repository.getByProntuario(prontuario)

            if (existingUser != null) { // Se já existir o usuário
                _user.value = existingUser

                return "Login bem-sucedido!"
            } else {
                // Caso o usuário não exista, cria um novo usuário
                if (nome.isNotEmpty()) {
                    val newUser = User(prontuario, nome)
                    repository.insert(newUser)
                    _user.value = newUser

                    return "Usuário registrado com sucesso! Login realizado."
                } else {
                    return "Nome não fornecido para novo usuário."
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()

            return "Erro ao tentar fazer login ou registrar usuário: ${e.message}"
        }

    }

}