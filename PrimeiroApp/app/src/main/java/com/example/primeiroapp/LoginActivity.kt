package com.example.primeiroapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()
        val criarConta = findViewById<TextView>(R.id.text_criarConta)

        criarConta.setOnClickListener {
            val abrirDatePickerActivity = Intent(this, Cadastro::class.java)
            startActivity(abrirDatePickerActivity)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.text_criarConta -> {
                Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}