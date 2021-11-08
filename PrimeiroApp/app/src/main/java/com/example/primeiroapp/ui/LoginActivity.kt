package com.example.primeiroapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiroapp.R
import com.example.primeiroapp.utils.autenticar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()
        val criarConta = findViewById<TextView>(R.id.text_criarConta)
        val buttonEntrar = findViewById<Button>(R.id.button_entrar)

        val editEmail = findViewById<EditText>(R.id.edit_text_email)
        val editSenha = findViewById<EditText>(R.id.edit_text_senha)

        buttonEntrar.setOnClickListener {
            val autenticou = autenticar(editEmail.text.toString(),
                    editSenha.text.toString(),
                    this)

            if (autenticou){
                val intent =  Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

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