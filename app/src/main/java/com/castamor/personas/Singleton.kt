package com.castamor.personas

import Persona

object Singleton {
    private val personas: MutableList<Persona> = mutableListOf()

    fun agregarPersona(persona: Persona) {
        personas.add(persona)
    }

    fun eliminarPersona(persona: Persona) {
        personas.remove(persona)
    }

    fun tamaño(): Int {
        return personas.size
    }

    fun obtenerLista(): List<Persona> {
        return personas.toList()
    }

    fun vaciarLista() {
        personas.clear()
    }
}