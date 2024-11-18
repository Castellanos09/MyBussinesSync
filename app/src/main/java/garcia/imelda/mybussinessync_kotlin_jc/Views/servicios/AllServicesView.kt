package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable

//PASAR ESTOS PARAMETROS A LA FUNCION UNA VEZ ESTÉ LISTA LA VISTA
//navController: NavController, notasVM: NotasViewModel
fun AllServicesView (navController: NavController, serviciosVM: ServiciosViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White,
                ),

                title = { Text(text = "Servicios") },
                navigationIcon = {

                    IconButton(onClick = {
                        // navController.popBackStack() //REGRESA A LA VISTA PRINCIPAL
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                        )
                    }
                })
        }
    ) { paddingValues ->
        Column(modifier = androidx.compose.ui.Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
        }
    }
}