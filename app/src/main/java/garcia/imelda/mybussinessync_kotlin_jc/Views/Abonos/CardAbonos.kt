package garcia.imelda.mybussinessync_kotlin_jc.Views.Abonos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import garcia.imelda.mybussinessync_kotlin_jc.R

@Composable

fun CardAbonos(
    descripcion: String,
    fecha: String,
    monto: String,
    onClick: () -> Unit
) {

    //INICIA DISEÑO DE CARD
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
            //TEXTO PARA DEFINIR COLUMNAS
            Row(
                modifier = Modifier
                    //.padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Descripción", fontWeight = FontWeight.Bold, fontSize = 20.sp )
                Text(text = "Fecha", fontWeight = FontWeight.Bold, fontSize = 20.sp )
                Text(text = "Monto", fontWeight = FontWeight.Bold, fontSize = 20.sp )
            }

            //SE MUESTRAN DATOS POR FILA
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${descripcion}", modifier = Modifier.fillMaxWidth(), fontSize = 15.sp)
                Text(text = "${fecha}", modifier = Modifier.fillMaxWidth(), fontSize = 15.sp)
                Text(text = "${monto}", modifier = Modifier.fillMaxWidth(), fontSize = 15.sp)
            }


            Spacer(modifier = Modifier.weight(1f))

            //BOTONES
            Row(
                modifier = Modifier
                    //.padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                //ICONO MODIFICAR
                Button(
                    onClick = {
                        //
                    },
                    modifier = Modifier,
                    //.padding(start = 90.dp, end = 90.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.darkGreen),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.darkGreen),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "")
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
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                }

            }

        }

    }
}