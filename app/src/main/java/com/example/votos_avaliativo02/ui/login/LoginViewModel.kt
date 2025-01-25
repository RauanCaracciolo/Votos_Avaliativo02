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
    fun login(prontuario: String, nome: String): Boolean {

        try {
            if(checkExistence(prontuario)){
                return false
            }else{
                if (nome.isNotEmpty()) {
                    val newUser = User(prontuario, nome)
                    repository.insert(newUser)
                    _user.value = newUser

                    return true
                } else {
                    return false
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }
    fun checkExistence(prontuario: String):Boolean{
        return try {
            val existingUser = repository.getByProntuario(prontuario)
            existingUser != null
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}