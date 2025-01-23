package com.example.votos_avaliativo02.data.repository

import android.content.Context
import com.example.votos_avaliativo02.data.database.MyDatabaseHelper
import com.example.votos_avaliativo02.data.database.VotoDao
import com.example.votos_avaliativo02.data.model.Voto

class VotoRepository(context: Context) {

    private val dbHelper = MyDatabaseHelper(context)
    private val dao = VotoDao(dbHelper)

    fun insert(voto: Voto): Long = dao.insert(voto)

    fun getByCode(code: String): Boolean = dao.getByCode(code)

    fun getByProtuario(prontuario: String): Boolean = dao.getByProtuario(prontuario)

    fun getAll(): List<Voto> = dao.getAll()

}