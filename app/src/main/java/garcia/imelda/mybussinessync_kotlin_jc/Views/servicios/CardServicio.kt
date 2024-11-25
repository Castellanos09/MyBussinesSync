package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import garcia.imelda.mybussinessync_kotlin_jc.Models.ServiceState
import garcia.imelda.mybussinessync_kotlin_jc.R

@Composable

fun CardServicio(
    cliente: String,
    color: String,
    vehiculo: String,
    numero: String,
    presupuesto: String,
    servicio: String,
    estado: String,

    onClick: () -> Unit
) {
    // Estado para controlar la visibilidad de la ventana modal
    val showModal = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(20.dp),
        shape = RoundedCornerShape(
            topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.grisBajito))

    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            //CLIENTE
            //Text(text = "Cliente: "+cliente, modifier = Modifier.fillMaxWidth(), fontSize = 20.sp,)
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Cliente: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "${cliente}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Contacto: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${numero}", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Vehiculo: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${vehiculo}", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)

            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Color: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${color}", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Servicio: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${servicio}", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Presupuesto: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(
                    text = "$${presupuesto}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.darkGreen)
                )
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "Estado: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${estado}", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
            }


            Spacer(modifier = Modifier.weight(1f))


            Row(
                modifier = Modifier
                    //.padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //ICONO DETALLE
                Button(
                    onClick = {
                        showModal.value = true // Muestra la ventana modal
                    },
                    modifier = Modifier,
                        //.padding(start = 90.dp, end = 90.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.detailColor),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.detailColor),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Detalles",  modifier = Modifier.size(20.dp))
                }

                //Spacer
                //Spacer(modifier = Modifier.width(10.dp))


                //ICONO LLAMADA
                Button(
                    onClick = {
                        //
                    },
                    modifier = Modifier,
                        //.padding(start = 120.dp, end = 120.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.phoneColor),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.phoneColor),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(imageVector = Icons.Default.Call, contentDescription = "Llamado",  modifier = Modifier.size(20.dp))
                }

                //ICONO EDITAR

                Button(
                    onClick = {
                        //
                    },
                    modifier = Modifier,
                    //.padding(start = 90.dp, end = 90.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.editColor),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.editColor),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "",  modifier = Modifier.size(20.dp))
                }

                //ICONO ELIMINAR

                Button(
                    onClick = {
                        //
                    },
                    modifier = Modifier,
                        //.padding(start = 90.dp, end = 90.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.trashColor),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.trashColor),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "",  modifier = Modifier.size(20.dp))
                }

            }

        }

    }

    // Ventana modal para "Adeudos" y "Abonos"
    if (showModal.value) {
        AlertDialog(
            onDismissRequest = { showModal.value = false },// Cierra la ventana modal
            text = {
                Text(text = "Seleccione una acción:", fontSize = 25.sp)
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Lógica para ir a "Adeudos"
                        showModal.value = false // Cierra el modal
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.azulFuerte),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Adeudos")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Lógica para ir a "Abonos"
                        showModal.value = false // Cierra el modal
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.azulFuerte),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Abonos")
                }
            }
        )
    }
}

