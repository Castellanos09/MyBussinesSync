package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.material3.contentColorFor
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.ServiciosViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//FALTA PEGAR ESTOS PARAMETROS EN LA FUNCION
fun AddServicioView(navController: NavController, serviciosVM: ServiciosViewModel) {

    var cliente by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var vehiculo by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var servicio by remember { mutableStateOf("") }
    var presupuesto by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("Pendiente") }
    val context = LocalContext.current


    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,

                    ),

                title = { Text(text = "Agregar Servicio")},
                navigationIcon = {

                    IconButton(onClick = {
                        navController.navigate("Home") //REGRESA A LA VISTA PRINCIPAL
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                        )
                    }
                })
        }

    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){


            OutlinedTextField(
                value =  cliente,
                onValueChange = {cliente = it},
                label = { Text(text = "Nombre del cliente")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            //INGRESAR UNA DESCRIPCIÓN
            OutlinedTextField(
                value = numero,
                onValueChange = {numero = it},
                label = { Text(text = "Contacto del cliente")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))


            OutlinedTextField(
                value = vehiculo,
                onValueChange = {vehiculo = it},
                label = { Text(text = "Marca del vehiculo")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            OutlinedTextField(
                value = color,
                onValueChange = {color = it},
                label = { Text(text = "Color del vehiculo")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            OutlinedTextField(
                value = servicio,
                onValueChange = {servicio = it},
                label = { Text(text = "Descripción del servicio")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))


            OutlinedTextField(
                value = presupuesto,
                onValueChange = {presupuesto = it},
                label = { Text(text = "Presupuesto estimado")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), // Teclado específico para decimal
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            //AGREGA UN SEVICIO NUEVO A LA BD
            Button(onClick = {
                // Verificar si algún campo está vacío
                if (cliente.isBlank() || numero.isBlank() || vehiculo.isBlank() || color.isBlank() || servicio.isBlank() || presupuesto.isBlank()) {
                    Toast.makeText(context, "Por favor, complete todos los campos vacíos antes de guardar.", Toast.LENGTH_SHORT).show()
                } else {
                    // Guardar el servicio si todos los campos están completos
                    serviciosVM.saveNewService(cliente, color, numero, presupuesto, servicio, vehiculo, estado) {
                        Toast.makeText(context, "Servicio guardado correctamente", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    }
                }
            },
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
                Text(text = "Guardar servicio")
            }
        }
    }
}

