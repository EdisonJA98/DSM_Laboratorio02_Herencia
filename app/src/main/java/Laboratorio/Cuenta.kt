package Laboratorio

open class Cuenta(
    protected var saldo: Float,
    protected var tasaAnual: Float
) {
    protected var numConsignaciones: Int = 0
    protected var numRetiros: Int = 0
    protected var comisionMensual: Float = 0f

    open fun consignar(cantidad: Float)
    {
        if (cantidad > 0)
        {
            saldo += cantidad
            numConsignaciones++
        }
    }

    open fun retirar(cantidad: Float)
    {
        if (cantidad > 0 && cantidad <= saldo)
        {
            saldo -= cantidad
            numRetiros++
        }
    }

    protected fun calcularInteresMensual()
    {
        val interesMensual = saldo * (tasaAnual / 12 / 100)
        saldo += interesMensual
    }

    open fun extractoMensual()
    {
        saldo -= comisionMensual
        calcularInteresMensual()
    }

    open fun imprimir()
    {
        println("Saldo: $saldo")
        println("Consignaciones: $numConsignaciones")
        println("Retiros: $numRetiros")
        println("Tasa anual: $tasaAnual%")
        println("Comision mensual: $comisionMensual")
    }
}