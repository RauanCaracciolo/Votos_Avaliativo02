package com.example.votos_avaliativo02.data.repository

import android.content.Context
import com.example.votos_avaliativo02.data.database.MyDatabaseHelper
import com.example.votos_avaliativo02.data.database.UserDao
import com.example.votos_avaliativo02.data.model.User

class UserRepository(context: Context) {

    private val dbHelper = MyDatabaseHelper(context)
    private val dao = UserDao(dbHelper)

    fun insert(user: User) = dao.insertUser(user)

    fun getAll(): List<User> = dao.getAll()

    fun getByProntuario(prontuario: String): User? = dao.getByProntuario(prontuario)

}