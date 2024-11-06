package garcia.imelda.mybussinessync_kotlin_jc.Views.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel

//ESTA ES LA VISTA DEL LOGIN

@Composable
//SE CREA LA FUNCION Y SE PASAN LOS PARAMETROS NECESARIOS DE LOS VIEWMODEL
fun LoginView(NavController: NavHostController, loginVM: LoginViewModel) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

        var email by remember {mutableStateOf("")} //EMAIL
        var password by remember {mutableStateOf("")} //PASSWORD


        //TITULO LOGIN
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Bienvenido(a)",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp)

        //ICONO LOGIN
        Image(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .padding(15.dp),
            painter = painterResource(id = R.drawable.logotipo_mybs),
            contentDescription = "IconoLogin"
        )


        //CAMPO EMAIL
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        //CAMPO PASSWORD
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            //SE OCULTA LA CONTRASEÑA
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        //ESPACIADO ENTRE ELEMENTOS
        Spacer(modifier = Modifier.height(20.dp))

        //BOTON DE LOGIN
       Button(
           onClick = {
               loginVM.login(email, password) {
                   NavController.navigate("Home")
               }
           },
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 20.dp, end = 20.dp)) {
           Text(text = "Ingresar")
       }

        //BOTON DE REGISTRO
        Button(
            onClick = {
                NavController.navigate("Register")

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)) {
            Text(text = "Registrarme")
        }
    }
}
