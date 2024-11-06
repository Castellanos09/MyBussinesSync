package garcia.imelda.mybussinessync_kotlin_jc.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.LoginView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Notas.HomeView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Register.RegisterView

@Composable
fun NavManager(
    //SE RECIBEN LOS VIEWMODELS EXTRAIDOS DE MAINACTIVITY
    loginVM: LoginViewModel,
    registerVM : RegisterViewModel,
    notasVM : NotasViewModel,

){
    val NavController = rememberNavController()

    //DEFINE LA VISTA POR DEFAULT, EN ESTE CASO ES LA INTERFAZ DE LOGIN
    NavHost(navController = NavController, startDestination = "Login"){

        //SE DEFINEN RUTAS DE LA APLICACIÓN
        composable("Login"){
            LoginView(NavController, loginVM)
        }
        composable("Register"){
            RegisterView(NavController, registerVM)
        }

        composable("Home"){
            HomeView(NavController, notasVM)
        }

    }
}