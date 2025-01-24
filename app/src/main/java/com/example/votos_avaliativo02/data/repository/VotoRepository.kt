package com.example.votos_avaliativo02.data.repository

import android.content.Context
import com.example.votos_avaliativo02.data.database.MyDatabaseHelper
import com.example.votos_avaliativo02.data.database.VotoDao
import com.example.votos_avaliativo02.data.model.User
import com.example.votos_avaliativo02.data.model.Voto

class VotoRepository(context: Context) {

    private val dbHelper = MyDatabaseHelper(context)
    private val dao = VotoDao(dbHelper)

    fun insert(voto: Voto) = dao.insert(voto)

    fun getByCode(code: String): Voto? = dao.getByCode(code)

    fun getAll(): List<Voto> = dao.getAll()

}