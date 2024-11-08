package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    private val auth : FirebaseAuth = Firebase.auth

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            onSuccess()
                        }
                    }
                    .addOnCompleteListener {
                        Log.d("error", "Error al iniciar sesion")
                    }
            } catch (e: Exception) {
                Log.d("error", "${e.message}")

            }
        }
    }
}