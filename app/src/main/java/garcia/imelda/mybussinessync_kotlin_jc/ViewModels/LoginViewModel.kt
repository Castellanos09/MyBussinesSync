package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import garcia.imelda.mybussinessync_kotlin_jc.Models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() { // Se crea el ViewModel para manejar la lógica de autenticación en el login y registro de usuario.

    // Inicializa la instancia de FirebaseAuth para manejar la autenticación de Firebase.
    private val auth: FirebaseAuth = Firebase.auth

    // Variable que controla la visibilidad de una alerta en la UI. Se usa mutableStateOf para permitir la observación de cambios.
    var showAlert by mutableStateOf(false)

    /**
     * Función para iniciar sesión con Firebase Authentication.
     * @param email Correo del usuario.
     * @param password Contraseña del usuario.
     * @param onSuccess Función de callback que se ejecuta si el login es exitoso.
     */
    fun login(email: String, password: String, onSuccess: () -> Unit) {
        // Ejecuta la tarea en una corrutina en viewModelScope para evitar bloquear el hilo principal.
        viewModelScope.launch {
            try {
                // Intenta iniciar sesión con el correo y contraseña proporcionados.
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task -> // Listener para saber si el login fue exitoso.
                        if (task.isSuccessful) {
                            // Si la autenticación es exitosa, se ejecuta el callback onSuccess.
                            onSuccess()
                        } else {
                            // Si falla el login, muestra la alerta y registra el error en los logs.
                            Log.d("Firebase Error", "Usuario y contraseña incorrectos")
                            showAlert = true
                        }
                    }
            } catch (e: Exception) {
                // Captura cualquier excepción, registrando el error en los logs.
                Log.d("Jetpack Error", "ERROR: ${e.localizedMessage}")
            }
        }
    }

    /**
     * Función para registrar un nuevo usuario en Firebase Authentication.
     * @param email Correo del usuario.
     * @param password Contraseña del usuario.
     * @param username Nombre de usuario para guardar en la base de datos.
     * @param onSuccess Función de callback que se ejecuta si la creación del usuario es exitosa.
     */
    fun createuser(email: String, password: String, username: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                // Intenta crear un nuevo usuario con el correo y contraseña proporcionados.
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task -> // Listener para saber si la creación del usuario fue exitosa.
                        if (task.isSuccessful) {
                            // Si la creación es exitosa, se guarda el usuario en la base de datos y se ejecuta onSuccess.
                            saveUser(username)
                            onSuccess()
                        } else {
                            // Si falla la creación del usuario, muestra la alerta y registra el error en los logs.
                            Log.d("Firebase Error", "Error al crear usuario")
                            showAlert = true
                        }
                    }
            } catch (e: Exception) {
                // Captura cualquier excepción, registrando el error en los logs.
                Log.d("Jetpack Error", "ERROR: ${e.localizedMessage}")
            }
        }
    }

    /**
     * Función privada para guardar los datos del usuario en Firestore.
     * @param username Nombre de usuario para almacenar.
     */
    private fun saveUser(username: String) {
        // Obtiene el ID de usuario y correo electrónico del usuario autenticado actualmente.
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch ( Dispatchers.IO ){
            // Crea un objeto de usuario para almacenar en Firestore.
            val user = UserModel(
                userId = id.toString(),
                username = username,
                email = email.toString()
            )

            // Agrega el objeto de usuario a la colección "users" en Firestore.
            FirebaseFirestore.getInstance().collection("users")
                .add(user)
                .addOnSuccessListener {
                    // Si el guardado es exitoso, registra el éxito.
                    Log.d("Guardado", "Usuario guardado correctamente")
                }
                .addOnFailureListener {
                    // Si falla el guardado, registra el error en los logs.
                    Log.d("Firebase Error", "Error al guardar usuario")
                }
        }
    }

    /**
     * Función para cerrar la alerta de error o éxito en la UI.
     */
    fun closeAlert() {
        showAlert = false
    }
}
