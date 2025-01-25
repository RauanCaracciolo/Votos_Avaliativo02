package com.example.votos_avaliativo02.data.model

class Voto( val codigo: String, val valor: Int) {

    // Método criado para gerar o código de Voto
    companion object {
        fun generateRandomCode(): String {
            val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            return (1..10).map { chars.random() }.joinToString("")
        }
    }

}