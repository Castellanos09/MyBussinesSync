package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import garcia.imelda.mybussinessync_kotlin_jc.Models.ServiceState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdeudosViewModel : ViewModel() {

    //HACE LA CONEXIÓN A LA BD
    val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    //RECUPERA LOS DATOS DEL MODELO "SERVICESTATE"
    private val _serviceData = MutableStateFlow<List<ServiceState>>(emptyList())
    val servicesData: StateFlow<List<ServiceState>> = _serviceData


    // Función para guardar un servicio
    fun saveNewService(
        cliente: String,
        color: String,
        numero: String,
        presupuesto: String,
        servicio: String,
        vehiculo: String,
        estado: String,
        onSuccess: () -> Unit
    ) {
        val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newService = hashMapOf(
                    "cliente" to cliente,
                    "color" to color,
                    "numero" to numero,
                    "presupuesto" to presupuesto,
                    "servicio" to servicio,
                    "vehiculo" to vehiculo,
                    "estado" to estado,
                    "email" to email.toString()

                )
                firestore.collection("servicios").add(newService)
                    .addOnSuccessListener {
                        onSuccess()
                    }
            } catch (e: Exception) {
                Log.d("ERROR SAVE", "ERROR AL GUARDAR EL SERVICIO ${e.localizedMessage}")
            }
        }
    }

    // Traer todos los datos en base al email
    fun fetchServices() {
        val email = auth.currentUser?.email
        firestore.collection("servicios")
            .whereEqualTo("email", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val documents = mutableListOf<ServiceState>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        //Sacar los campos de FireStore y los documentos
                        val myDocument =
                            document.toObject(ServiceState::class.java).copy(idDoc = document.id)
                        documents.add(myDocument)
                    }
                }
                _serviceData.value = documents
            }
    }

    // Función para cerrar sesión
    fun logOut() {
        auth.signOut()
    }

}

