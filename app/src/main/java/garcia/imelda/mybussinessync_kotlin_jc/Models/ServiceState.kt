package garcia.imelda.mybussinessync_kotlin_jc.Models

data class ServiceState(
    val cliente: String = "",
    val color: String = "",
    val numero: String = "",
    val presupuesto: String = "",
    val servicio: String = "",
    val vehiculo: String = "",
    val estado: String = "",
   val adeudos: List<Adeudo> = emptyList(), // Lista de adeudos
    val abonos: List<Abono> = emptyList(),   // Lista de abonos

    val idDoc: String = "",
){
//     Modelo para un adeudo
    data class Adeudo(
        val descripcion: String = "",
        val monto: String = "",
        val idDoc: String = ""
    )

    // Modelo para un abono
    data class Abono(
        val descripcion: String = "",
        val fecha: String = "", // Cambiar a Timestamp si planeas usar Firebase Timestamp
        val monto: String = ""
    )
}
