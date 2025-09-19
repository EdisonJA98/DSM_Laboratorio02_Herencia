package Laboratorio

class CuentaCorriente(
    saldo: Float,
    tasaAnual: Float
) : Cuenta(saldo, tasaAnual)
{
    private var sobregiro: Float = 0f

    override fun retirar(cantidad: Float)
    {
        if (cantidad > 0)
        {
            if (cantidad <= saldo)
            {
                saldo -= cantidad
            }
            else
            {
                sobregiro += (cantidad - saldo)
                saldo = 0f
            }
            numRetiros++
        }
    }

    override fun consignar(cantidad: Float) {
        if (cantidad <= 0)
            return

        if (sobregiro <= 0) {
            super.consignar(cantidad)
        } else {
            val cubrir = minOf(cantidad, sobregiro)
            sobregiro -= cubrir
            saldo += (cantidad - cubrir)
        }

        numConsignaciones++
    }

    override fun extractoMensual()
    {
        super.extractoMensual()
    }

    override fun imprimir()
    {
        println("***** Informacion de la Cuenta Corriente *****")
        println("Saldo: $saldo")
        println("Comision mensual: $comisionMensual")
        println("Numero de transacciones: ${numConsignaciones + numRetiros}")
        println("Saldo de sobregiro: $sobregiro")
    }
}