package com.example.votos_avaliativo02.data.database

import android.content.ContentValues
import com.example.votos_avaliativo02.data.model.User
import com.example.votos_avaliativo02.data.model.Voto

class VotoDao(private val dbHelper: MyDatabaseHelper) {

    fun insert(voto: Voto) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("codigo", voto.codigo)
            put("opcao", voto.valor)
        }
        db.insert("votos", null, values)
    }

    fun getByCode(code: String): Voto? {
        val db = dbHelper.writableDatabase
        val cursor = db.query(
            "votos",
            arrayOf("codigo","opcao"),
            "codigo = ?",
            arrayOf(code),
            null,
            null,
            null
        )
        if(cursor.moveToFirst()){
            val codigo = cursor.getString(cursor.getColumnIndexOrThrow("codigo"))
            val opcao = cursor.getInt(cursor.getColumnIndexOrThrow("opcao"))
            cursor.close()
            return Voto(codigo, opcao)
        }else{
            return null
        }
    }

    fun getAll(): List<Voto> {
        val db = dbHelper.writableDatabase
        val list = mutableListOf<Voto>()
        val cursor = db.query(
            "votos",
            arrayOf("codigo","opcao"),
            null,
            null,
            null,
            null,
            null
        )
        while (cursor.moveToNext()){
            var codigo =  cursor.getString(cursor.getColumnIndexOrThrow("codigo"))
            val opcao = cursor.getInt(cursor.getColumnIndexOrThrow("opcao"))
            list.add(Voto(codigo, opcao))
        }
        return list
    }

}