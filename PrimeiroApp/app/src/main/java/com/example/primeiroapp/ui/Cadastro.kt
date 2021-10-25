package com.example.primeiroapp.ui

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.primeiroapp.R
import com.example.primeiroapp.model.Usuario
import com.example.primeiroapp.utils.convertStringToLocalDate
import java.time.LocalDate
import java.util.*



class Cadastro : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editData: EditText
    lateinit var radioF: RadioButton
    lateinit var radioM: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editEmail = findViewById(R.id.text_email)
        editSenha = findViewById(R.id.text_senha)
        editNome = findViewById(R.id.text_nome)
        editProfissao = findViewById(R.id.text_profissao)
        editAltura = findViewById(R.id.text_altura)
        editData = findViewById(R.id.text_data)
        radioF = findViewById(R.id.feminino)
        radioM = findViewById(R.id.masculino)

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
            //criar o objeto usuario
            val nascimento = convertStringToLocalDate(editData.text.toString())
            val usuario = Usuario(
                    1,
                    editNome.text.toString(),
                    editEmail.text.toString(),
                    editSenha.text.toString(),
                    0,
                    editAltura.text.toString().toDouble(),
                    LocalDate.of(
                            nascimento.year,
                            nascimento.monthValue,
                            nascimento.dayOfMonth
                    ),
                    editProfissao.text.toString(),
                    if (radioF.isChecked) 'F' else 'M'

            )

            //Salvar o registro
            //Em um SharedPreferences

            //A instrução abaixo irá criar um
            //arquivo SharedPreferences se não existir
            //Se existir ele será aberto para a edição

            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            //Vamos criar o objeto que permitirá a
            //edição dos dados do arquivo SharedPreferences

            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNacimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissão)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()
        }

        Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_SHORT).show()

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

//                if (editData.text.isEmpty()){
//                    editData.error = "O campo altura é obrigatório!"
//                }

                if (radioF.text.isEmpty()){
                    radioF.error = "O campo data é obrigatório!"
                }

                if (radioM.text.isEmpty()){
                    radioM.error = "O campo data é obrigatório!"
                }
            }
        }

        return  true
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

//        if (editData.text.isEmpty()){
//            editData.error = "O campo data é obrigatório!"
//            valido = false
//        }

        if (radioF.text.isEmpty()){
            radioF.error = "O campo feminino é obrigatório!"
            valido = false
        }

        if (radioM.text.isEmpty()){
            radioM.error = "O campo masculino é obrigatório!"
            valido = false
        }

        return valido
    }

}