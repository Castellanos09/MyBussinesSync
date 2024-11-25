package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import garcia.imelda.mybussinessync_kotlin_jc.Models.ServiceState
import garcia.imelda.mybussinessync_kotlin_jc.Models.ServiceState.Adeudo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdeudosViewModel : ViewModel() {

    //HACE LA CONEXIÓN A LA BD
    val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    //RECUPERA LOS DATOS DEL MODELO "SERVICESTATE"
    private val _adeudosData = MutableStateFlow<List<Adeudo>>(emptyList())
    val adeudosData: StateFlow<List<Adeudo>> = _adeudosData


    // Función para guardar un servicio
    fun saveNewAdeudo(

        descripcion: String,
        monto: String,
        idDoc: String,

//        total : Number,

        onSuccess: () -> Unit
    ) {
        val email = auth.currentUser?.email
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newAdeudo= hashMapOf(
                    "descripcion" to descripcion,
                    "monto" to monto,
                    "email" to email.toString(),
                )
                val servicioRef = firestore.collection("servicios").document(idDoc)

                // Guardar el adeudo dentro de la subcolección "adeudos"
                servicioRef.collection("adeudos").add(newAdeudo)
                    .addOnSuccessListener {
                        onSuccess()
                    } .addOnFailureListener { e ->
                        Log.d("ERROR SAVE", "ERROR AL GUARDAR EL ADEUDO ${e.localizedMessage}")
                    }
            } catch (e: Exception) {
                Log.d("ERROR SAVE", "ERROR AL GUARDAR EL ADEUDO ${e.localizedMessage}")
            }
        }
    }

    // Traer todos los datos en base al email
    fun fetchAdeudos(idDoc: String) {
        val email = auth.currentUser?.email
        firestore.collection("servicios")
            .document(idDoc)
            .collection("adeudos")
            .whereEqualTo("email", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    Log.e("Firebase", "Error al obtener adeudos: ${error.localizedMessage}")
                    return@addSnapshotListener
                }
                val documents = mutableListOf<Adeudo>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        val myDocument = document.toObject(Adeudo::class.java).copy(idDoc = document.id)
                        documents.add(myDocument)
                    }
                }
                _adeudosData.value = documents
            }
    }

    // Función para cerrar sesión
    fun logOut() {
        auth.signOut()
    }

}

