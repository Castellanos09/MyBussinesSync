package garcia.imelda.mybussinessync_kotlin_jc.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import garcia.imelda.mybussinessync_kotlin_jc.Models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel(){

private val auth : FirebaseAuth = Firebase.auth

    fun createUser(username : String, email : String, password : String, onSuccess : () -> Unit) {
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        saveUser(username)
                        onSuccess()
                    } else {
                        Log.d("error", "Error al crear usuario")

                    }
                }

            } catch (e: Exception) {
                Log.d("error", "${e.message}")
            }
        }
    }

    fun saveUser(username : String) {
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch (Dispatchers.IO){
            val user = UserModel(
                userId = id.toString(),
                username = username,
                email = email.toString()
            )

            FirebaseFirestore.getInstance().collection("users")
                .add(user)
                .addOnSuccessListener {
                    Log.d("success", "Usuario registrado correctamente")

                }
                .addOnFailureListener { e->
                    Log.d("error", "${e.message}")
                }
        }
    }
}