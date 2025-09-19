package Laboratorio

class CuentaAhorros(
    saldo: Float,
    tasaAnual: Float
) : Cuenta(saldo, tasaAnual)
{
    private var activa: Boolean = saldo >= 10000

    override fun consignar(cantidad: Float)
    {
        if (activa)
        {
            super.consignar(cantidad)
        }
        else
        {
            println("Cuenta inactiva, no se puede consignar.")
        }
    }

    override fun retirar(cantidad: Float)
    {
        if (activa)
        {
            super.retirar(cantidad)
        }
        else
        {
            println("Cuenta inactiva, no se puede retirar.")
        }
    }

    override fun extractoMensual()
    {
        if (numRetiros > 4)
        {
            comisionMensual += (numRetiros - 4) * 1000f
        }
        super.extractoMensual()
        activa = saldo >= 10000
    }

    override fun imprimir()
    {
        println("***** Informacion de la Cuenta de Ahorros *****")
        println("Saldo: $saldo")
        println("Comision mensual: $comisionMensual")
        println("Numero de transacciones: ${numConsignaciones + numRetiros}")
    }
}
