package garcia.imelda.mybussinessync_kotlin_jc.Views.Abonos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllAbonosView() {


    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),

                title = { Text(text = "Todos los abonos") },
                actions = {
                    IconButton(onClick = {
                        //
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

            //AQUI FALTA CODIGO PARA JALAR LOS DATOS DE LA BD

            //PARA QUE ESTO FUNCIONE DEBE ESTAR CONECTADO A LA BASE DE DATOS Y EN EL VIEWMODEL
            /*
            LazyColumn () {
                items(//falta aqui un valor que se define en el ViewModel){item->
                    CardAbonos(
                        descripcion = item.descripcion,
                        fecha = item.fecha,
                        monto = item.monto
                    )

            }

             */
        }

    }
}
