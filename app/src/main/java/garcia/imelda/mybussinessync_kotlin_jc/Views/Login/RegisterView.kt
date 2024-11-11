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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import garcia.imelda.mybussinessync_kotlin_jc.R
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.LoginViewModel
import garcia.imelda.mybussinessync_kotlin_jc.components.Alert

/**
 * Composable para la pantalla de registro de usuario.
 *
 * @param navController Controlador de navegación que permite redirigir a otras vistas.
 * @param loginVM Instancia de LoginViewModel que gestiona la lógica de autenticación, como la creación de usuarios y manejo de errores.
 *
 * Esta función muestra una interfaz de usuario que permite a los usuarios registrarse ingresando un nombre de usuario, correo electrónico y contraseña.
 * Contiene campos de texto, un botón de registro y una alerta de error en caso de fallo en el registro. Al completar el registro correctamente,
 * se navega a la pantalla de inicio.
 */

@Composable
fun RegisterView(navController: NavController, loginVM: LoginViewModel) {
    // Definimos una columna centrada para organizar los elementos de forma vertical y alineados al centro
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize() // La columna ocupará el tamaño completo de la pantalla
    ) {
        // Variables que recuerdan el estado actual de cada campo de texto (email, contraseña y usuario)
        var email by remember { mutableStateOf("") } // Estado para el campo de email
        var password by remember { mutableStateOf("") } // Estado para el campo de contraseña
        var username by remember { mutableStateOf("") } // Estado para el campo de nombre de usuario

        // Título de bienvenida
        Text(
            modifier = Modifier.padding(top = 10.dp), // Margen superior
            text = "Bienvenido(a)",
            fontWeight = FontWeight.Bold, // Negrita para resaltar el texto
            color = Color.Black,
            fontSize = 20.sp // Tamaño del texto
        )

        // Icono de la aplicación
        Image(
            modifier = Modifier
                .height(150.dp) // Altura de la imagen
                .width(150.dp) // Anchura de la imagen
                .padding(15.dp), // Margen alrededor de la imagen
            painter = painterResource(id = R.drawable.logotipo_proyecto), // Recurso de imagen
            contentDescription = "IconoLogin" // Descripción de accesibilidad
        )

        // Campo de entrada para el nombre de usuario
        OutlinedTextField(
            value = username,
            onValueChange = { username = it }, // Actualiza el estado con el valor ingresado
            label = { Text(text = "Usuario") }, // Etiqueta para el campo
            modifier = Modifier
                .fillMaxWidth() // El campo ocupa el ancho completo disponible
                .padding(start = 30.dp, end = 30.dp) // Margen horizontal
        )

        // Campo de entrada para el email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), // Teclado específico para email
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )

        // Campo de entrada para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "password") },
            visualTransformation = PasswordVisualTransformation(), // Oculta el texto para proteger la contraseña
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Teclado específico para contraseña
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )

        // Espaciador para crear un espacio entre el campo de contraseña y el botón de registro
        Spacer(modifier = Modifier.height(20.dp))

        // Botón para registrar el usuario
        Button(
            onClick = {
                // Llamada al método de registro en el ViewModel, con los datos ingresados
                loginVM.createuser(email, password, username) {
                    // Navega a la pantalla de inicio al completar el registro exitosamente
                    navController.navigate("Home")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Registrarse") // Texto del botón
        }

        // Alerta para mostrar un mensaje de error si el registro falla
        if (loginVM.showAlert) {
            Alert(
                title = "Error", // Título de la alerta
                message = "No se pudo registrar el usuario, debes usar un correo valido y una contraseña mayor o igual a 6 caracteres", // Mensaje de error
                confirmText = "Aceptar", // Texto del botón de confirmación
                onConfirmClick = { loginVM.closeAlert() } // Cierra la alerta al hacer clic en el botón de confirmación
            ) {}
        }
    }
}
