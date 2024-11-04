package garcia.imelda.mybussinessync_kotlin_jc.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.LoginView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Register.RegisterView

@Composable
fun NavManager(
    loginVM: LoginViewModel,
    registerVM : RegisterViewModel,
    notasVM : NotasViewModel,

){
    val NavController = rememberNavController()

    NavHost(navController = NavController, startDestination = "Login"){
        composable("Login"){
            LoginView(NavController, loginVM)
        }
        composable("Register"){
            RegisterView(NavController, registerVM)
        }
    }
}