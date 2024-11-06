package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class NotasViewModel : ViewModel(){
    private val auth : FirebaseAuth = Firebase.auth

    fun logout() {
        auth.signOut() //CERRAR SESIÓN
    }

}