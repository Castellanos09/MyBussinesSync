package garcia.imelda.mybussinessync_kotlin_jc.Models

// Declaración de una clase de datos llamada UserModel para representar un usuario
data class UserModel(
    val userId: String,   // Identificador único del usuario, de tipo String
    val username: String, // Nombre de usuario, de tipo String
    val email: String     // Correo electrónico del usuario, de tipo String
) {
    // Función para convertir una instancia de UserModel en un mapa mutable
    fun toMap(): MutableMap<String, Any> {
        // Crea y retorna un MutableMap (mapa mutable) con las propiedades de la clase
        return mutableMapOf(
            "user_id" to this.userId,   // Asocia "user_id" con el valor de userId
            "username" to this.username, // Asocia "username" con el valor de username
            "email" to this.email       // Asocia "email" con el valor de email
        )
    }
}