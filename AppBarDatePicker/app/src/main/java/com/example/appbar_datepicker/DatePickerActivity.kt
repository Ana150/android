package com.example.appbar_datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        supportActionBar!!.title = "Testatando menu"
        supportActionBar!!.subtitle = "Aprendendo a lidar com os menus"

        //criando um calendario
        val calendario = Calendar.getInstance()

        //determinar os dados (dia, mês e ano)
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH )

        //abrir o DatePicker
        val etDataNascimento = findViewById<EditText>(R.id.et_data)

        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                        etDataNascimento.setText("$_dia/$_mes/$_ano")
                    }, ano, mes, dia)
            dp.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_teste, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_save) {
//            Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
//        } else if (item.itemId == R.id.menu_settings) {
//            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
//        }

        when (item.itemId){
            R.id.menu_save -> {
                Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_settings -> {
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_perfil -> {
                Toast.makeText(this, "perfil", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_perfil2 -> {
                Toast.makeText(this, "Perfil 2", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }



}