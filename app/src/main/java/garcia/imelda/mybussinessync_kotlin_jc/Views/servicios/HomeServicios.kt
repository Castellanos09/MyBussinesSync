package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.roomcronoapp.components.FloatButton
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeServicios(navController: NavController, serviciosVM: ServiciosViewModel) {
    
   LaunchedEffect(Unit) {
      serviciosVM.fetchServices()
   }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),

                title = { Text(text = "Servicios")},
                actions = {
                    IconButton(onClick = {
                        navController.navigate("Login")
                    }) {
                        Icon(
                            imageVector =   Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "")
                    }
                })
        } ,
        floatingActionButton = {
            FloatButton {
                navController.navigate("AddServicio")
            }
        }

    ) {padding ->
        Column(modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally){
//            Button(onClick = {
//                navController.navigate("AddServicio")
//            },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 100.dp, end = 100.dp),
//                colors = ButtonColors(
//                    containerColor = colorResource(id = R.color.azulFuerte),
//                    contentColor = Color.White,
//                    disabledContainerColor = colorResource(id = R.color.azulBajito),
//                    disabledContentColor = Color.White
//                )
//
//            ) {
//                Text(text = "Agregar servicio")
//            }

            // Mostrar servicios
            val servicios by serviciosVM.servicesData.collectAsState()

            LazyColumn{
                items(servicios) { item ->
                    CardServicio(
                        cliente = item.cliente,
                        color = item.color,
                        vehiculo = item.vehiculo,
                        numero = item.numero,
                        presupuesto = item.presupuesto,
                        servicio = item.servicio,
                        estado = item.estado,
                        onClick = {
                        }
                    )
                }
            }

        }
    }
}


