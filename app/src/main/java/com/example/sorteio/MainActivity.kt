package com.example.sorteio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var tvSorteio: TextView
    private lateinit var etText: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var btnSortear: Button
    private lateinit var sorteio: Sorteio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvSorteio = findViewById(R.id.tvSorteio)
        this.etText = findViewById(R.id.etTexto)
        this.btnSortear = findViewById(R.id.btnSortear)
        this.btnCadastrar = findViewById(R.id.btnCadastrar)
        this.sorteio = Sorteio()

        this.btnCadastrar.setOnClickListener({ adicionarText() })
        this.btnSortear.setOnClickListener({ sorteador() })

    }

    fun adicionarText() {
        val texto = this.etText.text.toString()
        this.sorteio.adicionar(texto)
        Log.i("APP_SORTEIO", this.sorteio.listagem.toString())
        this.etText.text.clear()
    }

    fun sorteador() {
        val texto = this.sorteio.sortear()
        if (texto == null) {
            Toast.makeText(this, "Não possui textos cadastrados", Toast.LENGTH_SHORT)
                .show()
        } else {
            this.tvSorteio.text = texto
        }
    }
}