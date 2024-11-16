package garcia.imelda.mybussinessync_kotlin_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import garcia.imelda.mybussinessync_kotlin_jc.Navigation.NavManager
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.LoginView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.TabsView
import garcia.imelda.mybussinessync_kotlin_jc.ui.theme.MyBussinesSyncKotlinJCTheme

class MainActivity : ComponentActivity() {

    //SE CREAN LOS VIEWMODELS Y SE ASIGNAN A VARIABLES
    val loginVM : LoginViewModel by viewModels()
    val registerVM : RegisterViewModel by viewModels()
    //val notasVM : NotasViewModel by viewModels()
    val serviciosVM : ServiciosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyBussinesSyncKotlinJCTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    NavManager(loginVM, serviciosVM)
                }
            }
        }
    }
}

