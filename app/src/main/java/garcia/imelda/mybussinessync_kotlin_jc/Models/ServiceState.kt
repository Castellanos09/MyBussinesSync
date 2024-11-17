package garcia.imelda.mybussinessync_kotlin_jc.Models

data class ServiceState(
    val cliente: String = "",
    val color: String = "",
    val numero: String = "",
    val presupuesto: Number = 0,
    val servicio: String = "",
    val vehiculo: String = "",
    val adeudos: List<Adeudo> = emptyList(), // Lista de adeudos
    val abonos: List<Abono> = emptyList()   // Lista de abonos

){


    // Modelo para un adeudo
    data class Adeudo(
        val descripcion: String = "",
        val monto: Number = 0
    )

    // Modelo para un abono
    data class Abono(
        val descripcion: String = "",
        val fecha: String = "", // Cambiar a Timestamp si planeas usar Firebase Timestamp
        val monto: Number = 0
    )
}
