package garcia.imelda.mybussinessync_kotlin_jc.Views.Register


import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.RegisterViewModel
import java.lang.reflect.Modifier


@Composable
//SE CREA LA FUNCION Y SE PASAN LOS PARAMETROS NECESARIOS DE LOS VIEWMODEL
fun RegisterView(NavController: NavHostController, registerVM: RegisterViewModel) {

    Column (
       horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier.fillMaxSize()

    ) {
        var username by remember { mutableStateOf("") } //USERNAME
        var email by remember { mutableStateOf("") } // EMAIL
        var password by remember { mutableStateOf("") } //PASSWORD


        //TEXTO DE REGISTRO
        Text(
            modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),
            text = "Registro de usuario",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp
        )

        //ICONO DE REGISTRO
        Image(
            modifier = androidx.compose.ui.Modifier
                .padding(top = 10.dp)
                .height(150.dp)
                .width(150.dp),
            painter = painterResource(id = R.drawable.registro),
            contentDescription = "Logo de registro"
        )

        //CAMPO USER NAME
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username")},
            modifier = androidx.compose.ui.Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth())

        //CAMPO EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email")},
            modifier = androidx.compose.ui.Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth())

        //CAMPO PASSWORD
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = androidx.compose.ui.Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth())

        //ESPACIADO ENTRE ELEMENTOS
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        Button(
            onClick = {
                registerVM.createUser(username, email, password){
                    NavController.navigate("Home")

                }
            },
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)) {
            Text(text = "Ingresar")

        }
    }
}