package garcia.imelda.mybussinessync_kotlin_jc.Views.Notas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel

@Composable
fun AddNoteView(navController: NavController, notasVM: NotasViewModel) {

    var title by remember{ mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(){ pad ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(pad)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label = {Text(text = "Titulo") }

            )
        }
    }

}