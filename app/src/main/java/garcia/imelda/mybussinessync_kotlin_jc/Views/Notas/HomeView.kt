package garcia.imelda.mybussinessync_kotlin_jc.Views.Notas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel

@Composable
fun HomeView(NavController: NavHostController, notasVM: NotasViewModel) {
    Text(text = "Inicio")
}
