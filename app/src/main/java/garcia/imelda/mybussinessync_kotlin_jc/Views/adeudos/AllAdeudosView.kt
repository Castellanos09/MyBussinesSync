package garcia.imelda.mybussinessync_kotlin_jc.Views.Adeudos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.roomcronoapp.components.FloatButton
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.AdeudosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllAdeudosView(navController: NavController, adeudosVM : AdeudosViewModel){
    LaunchedEffect(Unit) {
//        serviciosVM.fetchServices()
    }

    Scaffold (
        topBar = {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),

                title = { Text(text = "Adeudos")},
                actions = {
                    IconButton(onClick = {
                        navController.navigate("Home")
                    }) {
                        Icon(
                            imageVector =   Icons.Default.Home,
                            contentDescription = "")
                    }
                })
        } ,
        floatingActionButton = {
            FloatButton {
                navController.navigate("AddAdeudo")
            }
        }

    ) {padding ->
        Column(modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally){
//
            // Mostrar servicios
//            val servicios by serviciosVM.servicesData.collectAsState()

            LazyColumn{
//                items(servicios) { item ->
//                    CardServicio(
//                        cliente = item.cliente,
//                        color = item.color,
//                        vehiculo = item.vehiculo,
//                        numero = item.numero,
//                        presupuesto = item.presupuesto,
//                        servicio = item.servicio,
//                        estado = item.estado,
//                        onClick = {
//                        }
//                    )
//                }
            }

        }
    }
}