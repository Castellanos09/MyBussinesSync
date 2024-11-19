package garcia.imelda.mybussinessync_kotlin_jc.Views.Adeudos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import garcia.imelda.mybussinessync_kotlin_jc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//FALTA AGREGAR PARAMETROS EN LA FUNCION
fun adeudosView() {


    //DECLARACION DE VARIABLES
    var descripcion by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    val context = LocalContext.current

//TOP BAR AZUL EN APP
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,

                    ),

                title = { Text(text = "Cargar un adeudo") },
                navigationIcon = {

                    //BOTON
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
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Spacer(modifier = Modifier.height(70.dp))

            Image(
                painter = painterResource(id = R.drawable.adeudo_icon),
                contentDescription = "AdeudoIcon")

            //TEXTFIELD CAMPO DESCRIPCION
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text(text = "Descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )

            //TEXTFIELD CAMPO MONTO
            OutlinedTextField(
                value = monto,
                onValueChange = { monto = it },
                label = { Text(text = "Monto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )

            //BOTON AGREGA UNA NOTA A LA BD
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp, end = 100.dp),
                colors = ButtonColors(
                    containerColor = colorResource(id = R.color.azulFuerte),
                    contentColor = Color.White,
                    disabledContainerColor = colorResource(id = R.color.azulBajito),
                    disabledContentColor = Color.White
                )

            ) {
                Text(text = "Agregar adeudo")
            }
        }
    }
}




@Composable
@Preview
fun adeudosViewPreview() {
    adeudosView()}
