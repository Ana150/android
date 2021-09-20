package com.example.relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editNome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("LIFE_CICLE","OnCreate")

        val buttonOk = findViewById<Button>(R.id.button_ok)
        editNome = findViewById<EditText>(R.id.edit_nome)
        val editPassword = findViewById<EditText>(R.id.edit_password)

        buttonOk.setOnClickListener {

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE_CICLE","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE_CICLE","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFE_CICLE","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE_CICLE","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE_CICLE","OnDestroy")
    }

    fun validar() {

    }
}