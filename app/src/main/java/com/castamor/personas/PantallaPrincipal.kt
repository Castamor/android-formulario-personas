package com.castamor.personas

import Persona
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PantallaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_principal)

        // Obtener componentes y botones
        val nombre = findViewById<EditText>(R.id.nombreInput)
        val edad = findViewById<EditText>(R.id.edadInput)
        val domicilio = findViewById<EditText>(R.id.domicilioInput)
        val genero = findViewById<EditText>(R.id.generoInput)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostar = findViewById<Button>(R.id.btnMostrar)

        // Agregar funcionalidad al botón agregar
        btnAgregar.setOnClickListener {
            var infoCorrecta = true

            // En caso de que la información NO sea correcta
            if ( ComponenteToString(nombre).equals("") || ComponenteToInt(edad).equals(0) || ComponenteToString(domicilio).equals("") || ComponenteToString(genero).equals("") ) {
                infoCorrecta = false
                Notificacion(this, "Alguno de los campos están vacíos o incorrectos.")
            }

            // En caso de que la información SÍ sea correcta
            if (infoCorrecta) {
                Singleton.agregarPersona(Persona(
                                            ComponenteToString(nombre),
                                            ComponenteToInt(edad),
                                            ComponenteToString(domicilio),
                                            ComponenteToString(genero)
                                        )
                )
                Notificacion(this, "Se agregó correctamente.")

                nombre.setText("")
                edad.setText("")
                domicilio.setText("")
                genero.setText("")
            }
        }

        btnMostar.setOnClickListener {
            if (Singleton.tamaño() > 0) {
                val mostrarPersonas = Intent(this, MostrarPersonas::class.java)
                startActivity(mostrarPersonas)
            } else {
                Notificacion(this, "¡No hay ninguna persona en la lista!")
            }
        }

        // Funcionalidades
        val nombreLabel = findViewById<TextView>(R.id.textViewNombre)
        val edadLabel = findViewById<TextView>(R.id.textViewEdad)
        val domicilioLabel = findViewById<TextView>(R.id.textViewDomicilio)
        val generoLabel = findViewById<TextView>(R.id.textViewGenero)

        cambiarColorSiEstaActivo(this, nombre, nombreLabel)
        cambiarColorSiEstaActivo(this, edad, edadLabel)
        cambiarColorSiEstaActivo(this, domicilio, domicilioLabel)
        cambiarColorSiEstaActivo(this, genero, generoLabel)
    }

}