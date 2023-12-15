package com.castamor.personas

import Persona
import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor

fun ComponenteToString(componente: EditText): String {
    return componente.text.toString().trim()
}

fun ComponenteToInt( componente: EditText): Int {
    try {
        return componente.text.toString().trim().toInt()
    } catch (e: NumberFormatException) {
        return 0
    }
}

fun Notificacion(contexto: Context, texto: String) {
    Toast.makeText(contexto,texto, Toast.LENGTH_SHORT).show()
}

fun cambiarColorSiEstaActivo(contexto: Context, input: EditText, label: TextView) {
    input.setOnFocusChangeListener { _, hasFocus ->
        if (hasFocus) {
            // El EditText tiene foco, cambia el color del texto del TextView
            label.setTextColor(getColor(contexto, R.color.rosa))
        } else {
            // El EditText no tiene foco, cambia el color del texto del TextView a su color original
            label.setTextColor(getColor(contexto, R.color.gris))
        }
    }
}