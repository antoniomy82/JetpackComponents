package com.antoniomy.jetpackcomponents

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * URLS Interest:
 * https://m3.material.io/components/dialogs/overview
 * https://developer.android.com/jetpack/compose/components/dialog
 */
@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            },
            title = { Text(text = "Title") },
            text = { Text(text = "My first dialog") })
    }

}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "This is an Example")
                Text(text = "This is an Example")
                Text(text = "This is an Example")
                Text(text = "This is an Example")
            }
        }
    }
}

@Composable
fun AlertDialogExample(
    show: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    if (show) {
        AlertDialog(
            icon = { Icon(icon, contentDescription = "Example Icon") },
            title = { Text(text = dialogTitle) },
            text = { Text(text = dialogText) },
            onDismissRequest = { onDismissRequest() },
            confirmButton = {
                TextButton(onClick = { onConfirmation() }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismissRequest() }) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {

    val context = LocalContext.current

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }, content = {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Set backup account",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                AccountItem(
                    drawable = R.drawable.ic_launcher_background,
                    email = "ejemplo2@gmail.com"
                )

                AccountItem(
                    drawable = R.drawable.ic_launcher_foreground,
                    email = "ejemplo3@gmail.com"
                )
                AccountItem(
                    drawable = R.drawable.ic_add,
                    email = "Añadir nueva cuenta",
                    onClick = {
                        Toast.makeText(context, "Buton Añadir", Toast.LENGTH_SHORT).show()
                        onDismiss()
                    }
                )
            }
        })
    }
}

@Composable
fun AccountItem(@DrawableRes drawable: Int, email: String, onClick: () -> Unit = {}) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() }
        )
    }
}

@Composable
fun MyTittle(text:String, modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit){

    if(show){
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {

                MyTittle(text = "Phone ringtone", Modifier.padding(24.dp))

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray))

                var status by rememberSaveable { mutableStateOf("") }

                MyRadioButtonListByParameter(status) { status = it }

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray))

                Row (Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {  }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }

}