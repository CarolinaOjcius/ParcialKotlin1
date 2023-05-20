package com.example.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetalleAlumnoActivity : AppCompatActivity() {
    private lateinit var textViewDetalleNombre: TextView
    private lateinit var textViewDetalleEdad: TextView
    private lateinit var imageViewDetalle: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_alumno)

        textViewDetalleNombre= findViewById(R.id.textViewDetalleNombre)
        textViewDetalleEdad = findViewById(R.id.textViewDetalleEdad)
        imageViewDetalle=findViewById(R.id.imageViewDetalle)


        val bundle = intent.extras
        val nombreDetalle = bundle?.getString("name", "")
        val edadDetalle = bundle?.getInt("edad")
        val url = bundle?.getString("url") ?: ""

        textViewDetalleNombre.text = "Nombre: " +nombreDetalle
        textViewDetalleEdad.text="Edad:" + edadDetalle.toString()
        Glide.with(applicationContext)
            .load(url)
            .into(imageViewDetalle)
    }
}