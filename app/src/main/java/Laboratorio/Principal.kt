package Laboratorio

fun main()
{
    println("-------------- Ejercicio de Herencia -----------------\n")

    // Creamos una cuenta de ahorro
    val cuentaAhorros = CuentaAhorros(12000f, 12f)

    cuentaAhorros.consignar(3000f)
    cuentaAhorros.retirar(2000f)
    cuentaAhorros.extractoMensual()
    cuentaAhorros.imprimir()

    println("\n")

    // Creamos una cuenta corriente
    val cuentaCorriente = CuentaCorriente(5000f, 12f)

    cuentaCorriente.retirar(2000f) // genera sobregiro si lo retirado es mayor a lo que se tiene
    cuentaCorriente.consignar(3000f) // cubrir parte del sobregiro
    cuentaCorriente.extractoMensual()
    cuentaCorriente.imprimir()
}
