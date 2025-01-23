package com.example.votos_avaliativo02.data.database

import com.example.votos_avaliativo02.data.model.User

class UserDao(private val dbHelper: MyDatabaseHelper) {

    fun insertUser(user: User): Long {
        val db = dbHelper.writableDatabase

    }

    fun getAll(): List<User> {
        val db = dbHelper.writableDatabase

    }

    fun getByProntuario(prontuario: String): Boolean {
        val db = dbHelper.writableDatabase

    }

}