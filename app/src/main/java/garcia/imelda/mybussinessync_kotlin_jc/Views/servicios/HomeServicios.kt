package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeServicios(navController: NavController, serviciosVM: ServiciosViewModel) {

    //SE IMPORTA LA FUNCION PARA EXTRAER LOS DATOS DE LA BD
   LaunchedEffect(Unit) {
      serviciosVM.getServices()
   }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.azulFuerte),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),

                title = { Text(text = "Inicio")},
                actions = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector =   Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "")
                    }
                })
        }

    ) {padding ->
        Column(modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally){

            //
            val servicio = serviciosVM.serviceData

            LazyColumn {
                items(servicio){ item ->
                    Text(text = item.cliente)
                    Text(text = item.color)
                    Text(text = item.numero)
                    Text(text = item.presupuesto.toString())
                    Text(text = item.servicio)
                    Text(text = item.vehiculo)
                }
            }


            Button(onClick = {
                navController.navigate("AddServicio")
            },
                modifier = Modifier
                    .width(300.dp)
                    .padding(start = 110.dp, end = 110.dp),
                colors = ButtonColors(
                    containerColor = colorResource(id = R.color.azulFuerte),
                    contentColor = Color.White,
                    disabledContainerColor = colorResource(id = R.color.azulBajito),
                    disabledContentColor = Color.White
                )

            ) {
                Icon(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "IconoLogin")
            }
        }
    }
}




