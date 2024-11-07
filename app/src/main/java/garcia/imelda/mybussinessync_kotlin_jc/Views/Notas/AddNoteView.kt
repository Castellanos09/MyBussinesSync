package garcia.imelda.mybussinessync_kotlin_jc.Views.Notas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import garcia.imelda.mybussinessync_kotlin_jc.ViewModels.NotasViewModel
import java.lang.reflect.Modifier

@Composable
fun AddNoteView(navController: NavController, notasVM: NotasViewModel) {

    var title by remember{ mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold (){ paddingValues ->
        Column (modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){

            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label = {Text(text = "Title")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp,  end = 20.dp))

            OutlinedTextField(
                value = descripcion,
                onValueChange = )


        }
    }
}