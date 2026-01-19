package org.iesra

class Persona(var peso: Double, altura: Double) {

    var nombre: String? = null

    var altura: Double = altura
        set(value) {
            if (value > 0) {
                field = value
            }
        }


    val imc: Double
        get() = peso / (altura * altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona(nombre=$nombre, peso=$peso, altura=$altura, imc=${"%.2f".format(imc)})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        return peso == other.peso &&
                altura == other.altura &&
                nombre == other.nombre
    }
}

fun main() {

    val p1 = Persona(70.0, 1.75)
    val p2 = Persona("Luis", 80.0, 1.80)
    val p3 = Persona("Ana", 65.0, 1.65)

    println(p1)
    println(p2)
    println(p3)

    println("\n--- Persona 1 ---")

    var nombreValido: String?
    do {
        print("Introduce nombre para la persona 1: ")
        nombreValido = readLine()
    } while (nombreValido.isNullOrBlank())

    p1.nombre = nombreValido

    println("Nombre: ${p1.nombre}")
    println("Peso: ${p1.peso}")
    println("Altura: ${p1.altura}")

    println("\n--- Persona 3 ---")
    println("Peso: ${p3.peso}")
    println("Altura: ${p3.altura}")
    println("IMC: ${"%.2f".format(p3.imc)}")

    p3.altura = 1.80

    println("Tras modificar altura:")
    println("Peso: ${p3.peso}")
    println("Altura: ${p3.altura}")
    println("IMC: ${"%.2f".format(p3.imc)}")

    println("\n--- Persona 2 ---")

    p2.altura = p3.altura

    println("Persona 2: $p2")
    println("Persona 3: $p3")

    println("¿Persona 2 y Persona 3 son iguales? ${p2 == p3}")
}
