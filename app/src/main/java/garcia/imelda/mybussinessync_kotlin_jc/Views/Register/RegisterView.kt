package garcia.imelda.mybussinessync_kotlin_jc.Views.Register

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel


@Composable
//SE CREA LA FUNCION Y SE PASAN LOS PARAMETROS NECESARIOS DE LOS VIEWMODEL
fun RegisterView(NavController: NavHostController, registerVM: RegisterViewModel) {
    Text(text = "Registro de Usuarios")
}