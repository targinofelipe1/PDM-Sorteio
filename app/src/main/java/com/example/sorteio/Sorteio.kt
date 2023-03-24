package com.example.sorteio

class Sorteio {
    var listagem: MutableList<String>

    init {this.listagem = mutableListOf()}

    fun adicionar(texto: String){ this.listagem.add(texto)}

    fun sortear(): String?{
        if (this.listagem.isEmpty())
            return null

        return this.listagem.random()
    }


}
