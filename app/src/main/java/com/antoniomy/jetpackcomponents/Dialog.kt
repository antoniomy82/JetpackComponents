package com.antoniomy.jetpackcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
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
            confirmButton = { TextButton(onClick = { onConfirmation() }) {
                    Text("Confirm")
                }
            },
            dismissButton = { TextButton(onClick = { onDismissRequest() }) {
                    Text("Dismiss")
                }
            }
        )
    }
}