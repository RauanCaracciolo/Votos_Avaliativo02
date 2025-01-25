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

    fun getNome(prontuario: String):String?{
        if(checkExistence(prontuario)){
            return repository.getByProntuario(prontuario)?.nome.toString()
        }
        return null
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