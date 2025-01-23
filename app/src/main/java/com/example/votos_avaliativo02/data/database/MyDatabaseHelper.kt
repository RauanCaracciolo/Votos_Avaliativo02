package com.example.votos_avaliativo02.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_KEYS.DATABASE_NAME, null, DATABASE_KEYS.DATABASE_VERSION) {

    companion object DATABASE_KEYS{
        const val DATABASE_NAME = "votos_avaliativo.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableUser = """
            CREATE TABLE users (
                prontuario TEXT PRIMARY KEY,
                nome TEXT
            )
        """
        p0?.execSQL(createTableUser)
        val createTableVote = """
            CREATE TABLE votos(
                codigo TEXT PRIMARY KEY,
                opcao INT
            )
        """
        p0?.execSQL(createTableVote)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}