package garcia.imelda.mybussinessync_kotlin_jc.Views.Login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel

@Composable
fun TabsView(navController: NavController, loginVM: LoginViewModel){ //SE CREA LA VISTA DE LAS TABS

    var selectedTab by remember { mutableStateOf(0) }
    var tabs = listOf("Iniciar sesión", "Registrarse") //SE CREA LA LISTA DE TABS

    Column {
        TabRow(selectedTabIndex = selectedTab,
            contentColor = Color.Black,
            indicator = {
                tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTab])
                )
            }
            )
        {
            tabs.forEachIndexed { index, title -> //SE CREA UN BUCLE PARA CADA TAB
                Tab(selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }
        when(selectedTab){ //SE CREA UN WHEN PARA CADA TAB
            0 -> LoginView(navController, loginVM)
            1 -> RegisterView(navController, loginVM)
        }
    }
}