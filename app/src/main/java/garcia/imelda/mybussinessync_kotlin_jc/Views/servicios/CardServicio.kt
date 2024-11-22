package garcia.imelda.mybussinessync_kotlin_jc.Views.servicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import garcia.imelda.mybussinessync_kotlin_jc.R

@Composable
fun CardServicio (
    cliente: String,
    color: String,
    numero: String,
    presupuesto: Number,
    servicio: String,
    onClic: () -> Unit
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
            Text(text = "Cliente: "+cliente, modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)

            Row (modifier = Modifier.padding(10.dp)){
                //NÚMERO
                Text(text = "Contacto: "+numero, Modifier.padding(10.dp))
                //VEHICULO FALTA DEFINIR ¿?
                //Text(text = "Vehiculo: "+vehiculo, Modifier.padding(10.dp))
                //COLOR
                Text(text = "Color: "+color, Modifier.padding(10.dp))
                //SERVICIO
                Text(text = "Servicio: "+servicio, Modifier.padding(10.dp))
                //PRESUPUESTO
                Text(text = "Presupuesto: "+presupuesto.toString(), Modifier.padding(10.dp))

                
                Spacer(modifier = Modifier.weight(1f))
                //ICONO DETALLE
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.lupa_icon),
                        contentDescription = "detalleIcon")
                }
                //ICONO LLAMADA
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.phone_icon),
                        contentDescription = "detalleIcon")
                }
                //ICONO ELIMINAR
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.trash_icon),
                        contentDescription = "detalleIcon")
                }

            }


        }

    }
}