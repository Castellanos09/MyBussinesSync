package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ServiciosViewModel: ViewModel() {

    //HACE LA CONEXIÓN A LA BD
    val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    //RECUPERA LOS DATOS DEL MODELO "SERVICESTATE"
    private val _serviceData = MutableStateFlow<List<ServiceState>>(emptyList())
    val servicesData: StateFlow<List<ServiceState>> = _serviceData

    private val _services = mutableStateListOf<ServiceState>() // Reemplaza con tu modelo
    val services: List<ServiceState> get() = _services

    var state by mutableStateOf(ServiceState())
        private set

    // Colocar los valores en el form para editar
    fun onValue(value: String, text: String){
        when(text){
            "cliente" -> state = state.copy(cliente = value)
            "numero" -> state = state.copy(numero = value)
            "vehiculo" -> state = state.copy(vehiculo = value)
            "color" -> state = state.copy(color = value)
            "servicio" -> state = state.copy(servicio = value)
            "presupuesto" -> state = state.copy(presupuesto = value)
        }
    }




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
    ) { val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO){
            try{
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
            }catch(e: Exception){
                Log.d("ERROR SAVE", "ERROR AL GUARDAR EL SERVICIO ${e.localizedMessage}")
                }
            }
        }

    // Traer todos los datos en base al email
    fun fetchServices(){
        val email = auth.currentUser?.email
        firestore.collection("servicios")
            .whereEqualTo("email", email.toString())
            .addSnapshotListener{ querySnapshot, error ->
                if(error != null){
                    return@addSnapshotListener
                }
                val documents = mutableListOf<ServiceState>()
                if(querySnapshot != null){
                    for(document in querySnapshot){
                        //Sacar los campos de FireStore y los documentos
                        val myDocument = document.toObject(ServiceState::class.java).copy(idDoc = document.id)
                        documents.add(myDocument)
                    }
                }
                _serviceData.value = documents
            }
    }

    // Obtener un servicio
    fun getServiceById(documentId: String){
        firestore.collection("servicios")
            .document(documentId)
            .addSnapshotListener{ snapshot, _ ->
                if(snapshot != null){
                    val service = snapshot.toObject(ServiceState::class.java)
                    state = state.copy(
                        cliente = service?.cliente ?: "",
                        numero = service?.numero ?: "",
                        vehiculo = service?.vehiculo ?: "",
                        color = service?.color ?: "",
                        servicio = service?.servicio ?: "",
                        presupuesto = service?.presupuesto ?: "",
                    )
                }

            }
    }

    //Función para editar una nota
    fun updateService(idDoc: String, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            try{
                val editNote = hashMapOf(
                    "cliente" to state.cliente,
                    "numero" to state.numero,
                    "vehiculo" to state.vehiculo,
                    "color" to state.color,
                    "servicio" to state.servicio,
                    "presupuesto" to state.presupuesto

                    )
                firestore.collection("servicios").document(idDoc)
                    .update(editNote as Map<String, Any>)
                    .addOnSuccessListener {
                        onSuccess()
                    }

            }catch(e: Exception){
                Log.d("ERROR EDIT", "ERROR AL EDITAR NOTA ${e.localizedMessage}")
            }
        }
    }


    //Función para eliminar servicios
    fun deleteService(idDoc: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Elimina el documento en Firestore basado en el servicioID
                firestore.collection("servicios").document(idDoc).delete()
                    .addOnSuccessListener {
                        // Una vez eliminado de Firestore, también se elimina de la lista local
                        viewModelScope.launch(Dispatchers.Main) {
                            _services.removeIf { it.idDoc == idDoc }
                            Log.d("DELETE", "Servicio eliminado correctamente")
                        }
                    }
                    .addOnFailureListener { e ->
                        Log.e("DELETE ERROR", "Error al eliminar el servicio: ${e.localizedMessage}")
                    }
            } catch (e: Exception) {
                Log.e("DELETE ERROR", "Error inesperado al eliminar el servicio: ${e.localizedMessage}")
            }
        }
    }
    // Función para cerrar sesión
    fun logOut() {
        auth.signOut()
    }

}




