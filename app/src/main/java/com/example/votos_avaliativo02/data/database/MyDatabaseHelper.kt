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

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        db.execSQL("DROP TABLE IF EXISTS votos")

        onCreate(db)
    }

}