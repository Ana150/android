package com.example.primeiroapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.util.*



class Cadastro : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editData: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editEmail = findViewById(R.id.text_email)
        editSenha = findViewById(R.id.text_senha)
        editNome = findViewById(R.id.text_nome)
        editProfissao = findViewById(R.id.text_profissao)
        editAltura = findViewById(R.id.text_altura)
        editData = findViewById(R.id.text_data)

        supportActionBar!!.title = "Cadastro"


        //criando um calendario
        val calendario = Calendar.getInstance()

        //determinar os dados (dia, mês e ano)
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH )

        //abrir o DatePicker
        val etDataNascimento = findViewById<EditText>(R.id.text_data)

        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                        etDataNascimento.setText("$_dia/${_mes + 1}/$_ano")
                    }, ano, mes, dia)
            dp.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_teste, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos()){

        }
        return true

        when (item.itemId){
            R.id.menu_save -> {
                if (editEmail.text.isEmpty()){
                    editEmail.error = "O campo email é obrigatório!"
                }

                if (editSenha.text.isEmpty()){
                    editSenha.error = "O campo senha é obrigatório!"
                }
                if (editNome.text.isEmpty()){
                    editNome.error = "O campo nome é obrigatório!"
                }

                if (editProfissao.text.isEmpty()){
                    editProfissao.error = "O campo profissão é obrigatório!"
                }
                if (editAltura.text.isEmpty()){
                    editAltura.error = "O campo altura é obrigatório!"
                }

                if (editData.text.isEmpty()){
                    editData.error = "O campo data é obrigatório!"
                }
            }
        }


        return true
    }

    fun validarCampos() : Boolean{
        var valido = true

        if (editEmail.text.isEmpty()){
            editEmail.error = "O campo email é obrigatório!"
            valido = false
        }

        if (editSenha.text.isEmpty()){
            editSenha.error = "O campo senha é obrigatório!"
            valido = false
        }
        if (editNome.text.isEmpty()){
            editNome.error = "O campo nome é obrigatório!"
            valido = false
        }

        if (editProfissao.text.isEmpty()){
            editProfissao.error = "O campo profissão é obrigatório!"
            valido = false
        }

        if (editAltura.text.isEmpty()){
            editAltura.error = "O campo altura é obrigatório!"
            valido = false
        }
        if (editData.text.isEmpty()){
            editData.error = "O campo data é obrigatório!"
            valido = false
        }

        return valido
    }

}
