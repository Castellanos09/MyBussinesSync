package garcia.imelda.mybussinessync_kotlin_jc.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.LoginView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.TabsView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.checkSesion
import garcia.imelda.mybussinessync_kotlin_jc.Views.Notas.HomeView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Register.RegisterView

@Composable
fun NavManager(loginVM: LoginViewModel, notasVM: NotasViewModel){
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "checkSesion"){
        composable("checkSesion"){
            checkSesion(navController)
        }
        composable("Login"){
            TabsView(navController, loginVM)
        }
        composable("Home"){
            HomeView(navController, notasVM)
        }
    }
}