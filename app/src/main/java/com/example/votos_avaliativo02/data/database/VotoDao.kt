package com.example.votos_avaliativo02.data.database

import com.example.votos_avaliativo02.data.model.Voto

class VotoDao(private val dbHelper: MyDatabaseHelper) {

    fun insert(voto: Voto): Long {
        val db = dbHelper.writableDatabase

    }

    fun getByCode(code: String): Boolean {
        val db = dbHelper.writableDatabase

    }

    fun getByProtuario(prontuario: String): Boolean {
        val db = dbHelper.writableDatabase

    }

    fun getAll(): List<Voto> {
        val db = dbHelper.writableDatabase

    }

}