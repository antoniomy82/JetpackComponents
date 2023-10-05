package com.antoniomy.jetpackcomponents

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.antoniomy.jetpackcomponents.ui.theme.JetpackComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*
                    var myText by remember { mutableStateOf("") }
                    MyTextFieldStateHoisting(name = myText, onValueChanged = {myText=it})
                     */

                    /*
                    val myOptions = getOptions(listOf("Ejemplo1", "Titulo 2", "Ejemplo 4"))
                    Column {
                        MyTriStatusCheckBox()
                        myOptions.forEach { checkInfo -> MyCheckBoxWithTextCompleted(checkInfo) }
                    }
                     */

                    /*
                    var selected by rememberSaveable { mutableStateOf("Option 1") }
                    MyRadioButtonListByParameter(name = selected) { selected = it }
                     */


                    showDialogs()

                }
            }
        }
    }
}

@Composable
fun showDialogs(){
    var show by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    val confirmation:()->Unit = {Toast.makeText(context, "Button Confirm", Toast.LENGTH_SHORT).show()}
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Show dialog")
        }
        /*
        MyAlertDialog(
            show = show,
            onDismiss = { show = false },
            onConfirm = { Toast.makeText(context, "Button Confirm", Toast.LENGTH_SHORT).show() })
    */
        /*
        MySimpleCustomDialog(
            show = show,
            onDismiss = { show = false })

         */
        AlertDialogExample(
            show = show,
            onDismissRequest = { show = false },
            onConfirmation = { confirmation() },
            dialogTitle = "Tittle" ,
            dialogText = "Dialog text" ,
            icon = Icons.Default.Info

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsTheme {
        MyTriStatusCheckBox()
    }
}

