package garcia.imelda.mybussinessync_kotlin_jc.Views.Adeudos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import garcia.imelda.mybussinessync_kotlin_jc.R

@Composable
fun CardAdeudos(
    descripcion: String,
    monto: String,

    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(20.dp),
        shape = RoundedCornerShape(
            topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.grisBajito))

    ){
        Column (modifier = Modifier
            .padding(10.dp)) {
            //CLIENTE
            Text(text = "Adeudo", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)


                //DESCRIPCIÓN
                Text(text = "Descripción: "+descripcion, Modifier.padding(10.dp))
                //MONTO
                Text(text = "Monto: "+monto.toString(), Modifier.padding(10.dp))


                Spacer(modifier = Modifier.weight(1f))
                //ICONO ELIMINAR
                Button(onClick = {
                    //ACCION
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 100.dp, end = 100.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.trashColor),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.trashColor),
                        disabledContentColor = Color.White
                    )

                ) {
                    Icon(painter = painterResource(id = R.drawable.trash_icon),
                        contentDescription = "detalleIcon")
                }


        }
    }
}