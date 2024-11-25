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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.roomcronoapp.components.FloatButton
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.AdeudosViewModel
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllAdeudosView(navController: NavController, adeudosVM : AdeudosViewModel, serviciosVM: ServiciosViewModel, idDoc: String){
    LaunchedEffect(Unit) {
     adeudosVM.fetchAdeudos()
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
                navController.navigate("AddAdeudo/${idDoc}")
            }
        }

    ) {padding ->
        Column(modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally){



//
            // Mostrar adeudos
            val adeudos by adeudosVM.adeudosData.collectAsState()
            LazyColumn {
                items(adeudos){ item ->
                    CardAdeudos(
                        descripcion = item.descripcion, monto = item.monto,
                        onClick =  {
                        }
                    )

            }
////
            }

        }
    }
}