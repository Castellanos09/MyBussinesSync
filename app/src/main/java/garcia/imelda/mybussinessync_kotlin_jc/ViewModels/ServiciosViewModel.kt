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
import com.google.firebase.firestore.firestore
import garcia.imelda.mybussinessync_kotlin_jc.Models.ServiceState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiciosViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    var state by mutableStateOf(ServiceState())
        private set

    // Colocar los valores en el form para editar
    fun onValue(value: String, text: String, valueNumber: Number){
        when(text){
            "cliente" -> state = state.copy(cliente = value)
            "color" -> state = state.copy(color = value)
            "numero" -> state = state.copy(numero = value)
            "presupuesto" -> state = state.copy(presupuesto = valueNumber)
            "servicio" -> state = state.copy(servicio = value)
            "vehiculo" -> state = state.copy(vehiculo = value)
        }
    }

    // Función para guardar un servicio
    fun saveNewService(
        cliente: String,
        color: String,
        numero: String,
        presupuesto: Number,
        servicio: String,
        vehiculo: String,
        onSuccess: () -> Unit
    ){
        val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO){
            try{
                val newService = hashMapOf(
                    "cliente" to cliente,
                    "color" to color,
                    "numero" to numero,
                    "presupuesto" to presupuesto,
                    "servicio" to servicio,
                    "vehiculo" to vehiculo,
                    "email" to email.toString()

                )
                firestore.collection("servicios").add(newService)
                    .addOnSuccessListener {
                        onSuccess()
                    }
            }catch(e: Exception){
                Log.d("ERROR SAVE", "ERROR AL GUARDAR EL SERVICIO ${e.localizedMessage}")
            }
        }

    }

    // Función para cerrar sesión
    fun logout() {
        auth.signOut()
    }



}