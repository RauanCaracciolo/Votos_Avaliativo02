package com.example.votos_avaliativo02.data.database

import android.content.ContentValues
import com.example.votos_avaliativo02.data.model.User
import com.example.votos_avaliativo02.data.model.Voto

class UserDao(private val dbHelper: MyDatabaseHelper) {

    fun insertUser(user: User){
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("prontuario", user.prontuario)
            put("nome", user.nome)
        }
        db.insert("users", null, values)
    }

    fun getAll(): List<User> {
        val db = dbHelper.writableDatabase
        val list = mutableListOf<User>()
        val cursor = db.query(
            "users",
            arrayOf("prontuario","nome"),
            null,
            null,
            null,
            null,
            null
        )
        while (cursor.moveToNext()){
            var prt =  cursor.getString(cursor.getColumnIndexOrThrow("prontuario"))
            val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
            list.add(User(prt, nome))
        }
        return list
    }

    fun getByProntuario(prontuario: String): User? {
        val db = dbHelper.writableDatabase
        val cursor = db.query(
            "users",
            arrayOf("prontuario","nome"),
            "prontuario = ?",
            arrayOf(prontuario),
            null,
            null,
            null
        )
        if(cursor.moveToFirst()){
            val prt = cursor.getString(cursor.getColumnIndexOrThrow("prontuario"))
            val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
            cursor.close()
            return User(prt,nome)
        }else{
            return null
        }
    }

}