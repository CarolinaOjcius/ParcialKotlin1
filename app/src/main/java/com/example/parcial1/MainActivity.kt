package com.example.parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botonLogin: Button
    private lateinit var editTextNombreAlumno: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonLogin = findViewById(R.id.buttonLogin)
        editTextNombreAlumno = findViewById(R.id.editTextNombreAlumno)


        botonLogin.setOnClickListener {
            if (editTextNombreAlumno.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese nombre para continuar", Toast.LENGTH_SHORT).show()
            } else {
                val userName = editTextNombreAlumno.text.toString()
                val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("name", userName)
                editor.apply()
                val intent = Intent(this, ListaAlumnosActivity::class.java)
                startActivity(intent)
            }
        }

    }
}