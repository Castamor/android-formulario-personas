package com.castamor.personas

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MostrarPersonas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostrar_personas)

        val tabla = findViewById<LinearLayout>(R.id.tablaPersonas)
        val btnVaciar = findViewById<Button>(R.id.btnVaciar)

        Singleton.obtenerLista().forEach { persona ->
            // TABLE ROW
            val fila = TableRow(this)
            fila.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
            fila.gravity = Gravity.CENTER
            fila.setPadding(0, 5, 0, 5)

            // NOMBRE
            val nombreTextView = TextView(this)
            nombreTextView.layoutParams = TableRow.LayoutParams( 0, TableRow.LayoutParams.WRAP_CONTENT, 1f )
            nombreTextView.gravity = Gravity.CENTER
            nombreTextView.text = persona.nombre
            nombreTextView.setTextColor(getColor(R.color.negro))

            // EDAD
            val edadTextView = TextView(this)
            edadTextView.layoutParams = TableRow.LayoutParams( 0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            edadTextView.gravity = Gravity.CENTER
            edadTextView.text = persona.edad.toString()
            edadTextView.setTextColor(getColor(R.color.negro))

            // DOMICILIO
            val domicilioTextView = TextView(this)
            domicilioTextView.layoutParams = TableRow.LayoutParams( 0, TableRow.LayoutParams.WRAP_CONTENT, 1f )
            domicilioTextView.gravity = Gravity.CENTER
            domicilioTextView.text = persona.domicilio
            domicilioTextView.setTextColor(getColor(R.color.negro))

            // GENERO
            val generoTextView = TextView(this)
            generoTextView.layoutParams = TableRow.LayoutParams( 0, TableRow.LayoutParams.WRAP_CONTENT, 1f )
            generoTextView.gravity = Gravity.CENTER
            generoTextView.text = persona.genero
            generoTextView.setTextColor(getColor(R.color.negro))

            // ELIMINAR
            val eliminarTextView = TextView(this)
            eliminarTextView.layoutParams = TableRow.LayoutParams( 0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            eliminarTextView.gravity = Gravity.CENTER
            eliminarTextView.text = "X"
            eliminarTextView.setTypeface(null, Typeface.BOLD)
            eliminarTextView.setTextColor(getColor(android.R.color.holo_red_dark))
            eliminarTextView.setOnClickListener {
                Singleton.eliminarPersona(persona)
                tabla.removeView(fila)

                if (Singleton.tamaño() == 0) { finish() }
            }

            // AÑADIRLOS AL TABLEROW
            fila.addView(nombreTextView)
            fila.addView(edadTextView)
            fila.addView(domicilioTextView)
            fila.addView(generoTextView)
            fila.addView(eliminarTextView)

            tabla.addView(fila)
        }

        btnVaciar.setOnClickListener {
            Singleton.vaciarLista()
            Notificacion(this, "Lista vacía.")
            finish()
        }
    }

    fun terminarActividad(view: View) { finish() }

}