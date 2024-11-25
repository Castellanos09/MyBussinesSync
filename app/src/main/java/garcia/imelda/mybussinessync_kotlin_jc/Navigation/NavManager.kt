package garcia.imelda.mybussinessync_kotlin_jc.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.AdeudosViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel
import garcia.imelda.mybussinessync_kotlin_jc.Views.Adeudos.AddAdeudosView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Adeudos.AllAdeudosView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.LoginView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.TabsView
import garcia.imelda.mybussinessync_kotlin_jc.Views.Login.checkSesion
import garcia.imelda.mybussinessync_kotlin_jc.Views.servicios.AddServicioView
import garcia.imelda.mybussinessync_kotlin_jc.Views.servicios.AllServicesView
import garcia.imelda.mybussinessync_kotlin_jc.Views.servicios.HomeServicios

@Composable
fun NavManager(loginVM: LoginViewModel, serviciosVM: ServiciosViewModel, adeudosVM : AdeudosViewModel){
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "checkSesion"){
        composable("checkSesion"){
            checkSesion(navController)
        }
        composable("Login"){
            TabsView(navController, loginVM)
        }
        composable("Home"){
            HomeServicios(navController, serviciosVM)
        }
        composable( "AddServicio"){
            AddServicioView(navController, serviciosVM)
         }
        composable("AllServices"){
            AllServicesView(navController, serviciosVM)
        }
        composable( "Adeudo/{idDoc}", arguments = listOf(
            navArgument("idDoc") {type = NavType.StringType}
        )){
            val idDoc = it.arguments?.getString("idDoc") ?: " "
            AllAdeudosView(navController, adeudosVM,serviciosVM, idDoc = idDoc)
        }
        composable( "AddAdeudo/{idDoc}", arguments = listOf(
            navArgument("idDoc") {type = NavType.StringType}
        )){
            val idDoc = it.arguments?.getString("idDoc") ?: " "
            AddAdeudosView(navController, adeudosVM, idDoc = idDoc)
        }

    }
}