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

    //HACE LA CONEXIÓN A LA BD
    val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    //RECUPERA LOS DATOS DEL MODELO "SERVICESTATE"
    private val _serviceData = mutableStateOf<List<ServiceState>>(emptyList())
    val serviceData: List<ServiceState> = _serviceData.value

    // Colocar los valores en el form para editar
    // fun onValue(value: String, text: String, valueNumber: Number){
    //when(text){
    //  "cliente" -> _serviceData = _serviceData.copy(cliente = value)
    // "color" -> state = state.copy(color = value)
    //"numero" -> state = state.copy(numero = value)
    //"presupuesto" -> state = state.copy(presupuesto = valueNumber)
    //"servicio" -> state = state.copy(servicio = value)
    //"vehiculo" -> state = state.copy(vehiculo = value)
    //}
    // }

    // Función para guardar un servicio
    fun saveNewService(
        cliente: String,
        color: String,
        numero: String,
        presupuesto: Number,
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

        //FUNCION PARA EXTRAER TODOS LOS DATOS DE LA BD
        fun getServices() {
            val email = auth.currentUser?.email
            firestore.collection("servicios")
                .whereEqualTo("email", email.toString())
                .addSnapshotListener { querySnapshot, error ->
                    if (error != null) {
                        return@addSnapshotListener
                    }
                    val listaServicios = mutableListOf<ServiceState>()
                    if (querySnapshot != null) {
                        for (listaServicio in querySnapshot) {
                            //Sacar los campos de FireStore y los documentos
                            val service = listaServicio.toObject(ServiceState::class.java).copy(idlist = listaServicio.id)
                            listaServicios.add(service)

                        }
                    }
                    _serviceData.value = listaServicios
                }
        }


        //val email = auth.currentUser?.email
        //viewModelScope.launch(Dispatchers.IO){
        //  try{
        //  val newService = hashMapOf(
        //        "cliente" to cliente,
        //    "color" to color,
        //  "numero" to numero,
        //"presupuesto" to presupuesto,
        //"servicio" to servicio,
        //"vehiculo" to vehiculo,
        //"email" to email.toString()

        //  )
        //firestore.collection("servicios").add(newService)
        //  .addOnSuccessListener {
        //  onSuccess()
        //}
        //}catch(e: Exception){
        //  Log.d("ERROR SAVE", "ERROR AL GUARDAR EL SERVICIO ${e.localizedMessage}")

    // Función para cerrar sesión
    fun logOut() {
        auth.signOut()
    }

}




